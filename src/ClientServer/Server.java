/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN 
 */
public class Server {
    public static void main(String[] args) {
        InputStream in;
        DataOutputStream out;
        byte[] b = new byte[1024];
        byte[] a = new byte[1024];
        try {
            ServerSocket server = new ServerSocket(1107);
            while(true){
                Socket conn = server.accept();  
                System.out.println("aaaaa");
                in = conn.getInputStream();
                in.read(b);        
                String s = new String(b).trim();
                System.out.println(s);
                if(s.equals("a145")) System.out.println("ok");
                int m = 4;
                byte[] m1 = intToBytes(m);
                int n = 5;
                byte[] n1 = intToBytes(n);
                out = new DataOutputStream(conn.getOutputStream());
                out.write(m1);
                out.write(n1);
                conn.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }    
    
    private static byte[] intToBytes(int data) {
    return new byte[] {
        (byte)((data >> 24) & 0xff),
        (byte)((data >> 16) & 0xff),
        (byte)((data >> 8) & 0xff),
        (byte)((data >> 0) & 0xff),
    };
}
    
}
