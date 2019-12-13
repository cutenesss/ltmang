/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.b1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cuteness
 */
public class Server {
    DatagramSocket server;
    DatagramPacket receivePacket, sendPacket;
    byte[] sendBuff, receiveBuff;

    public Server() {
        try {
            server= new DatagramSocket(1107);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listening(){
        receiveBuff = new byte[1024];
        while(true){
            receivePacket = new DatagramPacket(receiveBuff, receiveBuff.length);
            try {
                server.receive(receivePacket); 
                sendBuff = "B16;4;6".getBytes();
                InetAddress ip = receivePacket.getAddress();
                int port = receivePacket.getPort();
                sendPacket = new DatagramPacket(sendBuff, sendBuff.length, ip, port);
                server.send(sendPacket);
                byte[] receive = new byte[1024];
                DatagramPacket receive2 = new DatagramPacket(receive, receive.length);
                server.receive(receive2);
                System.out.println(new String(receive2.getData()).trim());
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
