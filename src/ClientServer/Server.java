/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

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
                in = conn.getInputStream();
                in.read(b);        
                String s = new String(b, "UTF-8").trim();
                System.out.println(s);
                if(s.equals("a145")) System.out.println("ok");
                out = new DataOutputStream(conn.getOutputStream()); 
                int m = 4;
                int n = 5;
                out.writeInt(m);
                out.writeInt(n);
                System.out.println(m+" "+n);
                in.read(a);
                conn.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }    
    
    
}
