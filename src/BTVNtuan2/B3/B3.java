/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVNtuan2.B3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class B3 {
    public static void main(String[] args) throws IOException {
        String file = "C://Users//ADMIN//Documents//LTMang//src//BTVNtuan2//B3//SV.txt";
        InputStream fis = null;
        byte[] data = new byte[1024];
        try {          
            fis = new FileInputStream(file);
            while(fis.available()>0){
                fis.read(data);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(B3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(B3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        OutputStream fos=null;
        fos = new FileOutputStream("C://Users//ADMIN//Documents//LTMang//src//BTVNtuan2//B3//SVout.txt");
        fos.write(data);
    }
}
