/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.b2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cuteness
 */
public class Client {
    DatagramSocket client;
    DatagramPacket receive1, send, receive2;
    byte[] sendBuff, receiveBuff;
    InetAddress ip;
    
    public Client(){
        try {
            client = new DatagramSocket();
            try {
                ip = InetAddress.getByName("localhost");
            } catch (UnknownHostException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(){
        sendBuff = new byte[1024];
        
    }
}
