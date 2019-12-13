/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.b3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    byte[] receiveBuff, sendBuff;

    public Server() {
        try {
            server = new DatagramSocket(1109);
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
                byte[] data = receivePacket.getData();
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(in);
                try {
                    Student s1 = (Student) ois.readObject();
                    System.out.println(s1.getCode());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    Student s2 = new Student(313, "32sadasxczzcas1", 3213455);
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(s2);
                    InetAddress ip = receivePacket.getAddress();
                    int port = receivePacket.getPort();
                    sendBuff = out.toByteArray();
                    sendPacket = new DatagramPacket(sendBuff, sendBuff.length, ip, port);
                    server.send(sendPacket);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
