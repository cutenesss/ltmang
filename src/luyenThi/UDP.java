/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luyenThi;

import UDP.b3.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class UDP {

    DatagramSocket c;
    DatagramPacket sendPac, receivePac;
    byte[] send, receive;

    public UDP() {
        try {
            c = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void send() {
        send = new byte[1024];
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                Student s = new Student("a124");
                oos.writeObject(s);
                send = baos.toByteArray();
                sendPac = new DatagramPacket(send, send.length, ip, 1107);
                c.send(sendPac);
            } catch (IOException ex) {
                Logger.getLogger(UDP.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listen() {
        receive = new byte[1024];
        while (true) {
            receivePac = new DatagramPacket(receive, receive.length);
            try {
                c.receive(receivePac);
                byte[] data = receivePac.getData();
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bais);
                try {
                    Student s1 = (Student) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UDP.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(UDP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
