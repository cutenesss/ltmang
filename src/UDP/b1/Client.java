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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cuteness
 */
public class Client {

    DatagramSocket client;
    DatagramPacket sendPacket, receivePacket;
    byte[] receiveBuff, sendBuff;
    String res;

    public Client() {
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sending() {
        sendBuff = "D16BC".getBytes();
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            sendPacket = new DatagramPacket(sendBuff, sendBuff.length, ip, 1107);
            try {
                client.send(sendPacket);
                System.out.println("Si");
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listening() {
        receiveBuff = new byte[1024];
        while (true) {
            receivePacket = new DatagramPacket(receiveBuff, receiveBuff.length);
            try {
                client.receive(receivePacket);
                res = new String(receivePacket.getData()).trim();
                break;
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(res);
        String[] r = res.split(";");
        System.out.println(r[0]);
        int a = new Integer(r[1]);
        int b = new Integer(r[2]);
        String s1 = Integer.toString(ucln(a, b));
        String s2 = Integer.toString(bcnn(a, b));
        String send = r[0]+";" + s1+";" + s2;
        byte[] sendRes = send.getBytes();
        System.out.println(sendRes);
        DatagramPacket send2;
        try {
            send2 = new DatagramPacket(sendRes, sendRes.length, InetAddress.getByName("localhost"), 1107);
            try {
                client.send(send2);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            client.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int ucln(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    
    public int bcnn(int a, int b) {
        return a * b / ucln(a, b);
    }
}
