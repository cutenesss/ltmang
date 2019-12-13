/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVNtuan2.B1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class B2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String file = "C://Users//ADMIN//Documents//LTMang//src//BTVNtuan2//B1//test.txt";
        int res = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String tmp;
            while ((tmp = br.readLine()) != null){
                if( tmp.contains(s) ){
                    ++res;
                    System.out.println("a");
                    System.out.println("Line: " + res);
                    System.out.println(tmp);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(B2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
