/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luyenThi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class TCP {
    public static void main(String[] args) {
        byte[] a = new byte[1024];
        byte[] b = new byte[1024];
        try(
                Socket client = new Socket("127.0.0.1", 1107);
                DataInputStream inp = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                ) {
                    out.write("a145".getBytes());
                    inp.read(a);
                    inp.read(b);
                    ByteBuffer a1 = ByteBuffer.wrap(a);
                    ByteBuffer b1 = ByteBuffer.wrap(b);
                    System.out.println(a1.getInt() + "   " + b1.getInt());
        } catch (Exception ex) {
            Logger.getLogger(TCP.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
}
