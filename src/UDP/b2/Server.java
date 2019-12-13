/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.b2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cuteness
 */
public class Server {

    DatagramSocket server;
    DatagramPacket sendpacket, receivePacket;
    byte[] receiveBuff, sendBuff;

    public Server() {
        try {
            server = new DatagramSocket(1108);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listening() {
        receiveBuff = new byte[1024];
        while(true){
            receivePacket = new DatagramPacket(receiveBuff, receiveBuff.length);
            try {
                server.receive(receivePacket);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
