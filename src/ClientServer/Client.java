/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Client {

    public static void main(String[] args) {
        try (
                Socket client = new Socket("127.0.0.1", 1107);
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                DataInputStream in = new DataInputStream(client.getInputStream());) {
                    System.out.println("a");
                    out.writeUTF("a145");
                    int a = in.readInt();
                    int b = in.readInt();
                    System.out.println(a+" "+b);
                    out.writeInt(a+b);
                    out.writeInt(a*b);
                    client.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
