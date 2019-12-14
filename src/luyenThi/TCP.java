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
    
    public static void separate(String string) {
        StringBuilder alphabetsBuilder = new StringBuilder();
        StringBuilder numbersBuilder = new StringBuilder();
        StringBuilder symbolsBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isAlphabetic(ch)) {
                alphabetsBuilder.append(ch);
            } else if (Character.isDigit(ch)) {
                numbersBuilder.append(ch);
            } else {
                symbolsBuilder.append(ch);
            }
        }
        System.out.println("Alphabets in string: " + alphabetsBuilder.toString());
        System.out.println("Numbers in String: " + numbersBuilder.toString());
        System.out.println("Sysmbols in String: " + symbolsBuilder.toString()); 
    }
    
    public static String test2(String str){
        str = str.toLowerCase();
        String res ="";
        String[] s = str.split(" ");
        for(int i=0;i<s.length;i++){
            String s1="";
            if(s[i].length()!=0){
                s1+=Character.toUpperCase(s[i].charAt(0));
                if(s[i].length()>1){
                    s1+= s[i].substring(1);
                }
                res=res+s1+" ";
            }
        }
        res=res+"\b";
        return res;
    }
    
    public static String test3(String str){
        char[] c = str.toCharArray();
        char[] res="".toCharArray();
        int count=0;
        for(int i =0;i<c.length;i++){
            int j;
            for(j = 0;j<i;j++){
                if(c[i] == c[j]) break;
            }
            if(i==j){
                res[count]=c[i];
            }
        }
        return new String(res);
    }
    
    public static String test1(String str){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<str.length();i++){
            int a = (int) str.charAt(i);
            a+=4;
            res.append(Character.toString((char) a));
        }
        return res.toString();
    }
    
    public static String[] test4(String str){
        StringBuilder res1 = new StringBuilder();
        StringBuilder res2 = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(Character.isAlphabetic(str.charAt(i)) || Character.isDigit(str.charAt(i))){
                res1.append(str.charAt(i));
            } 
            else res2.append(str.charAt(i));
        }
        String[] res=null;
        res[0]=res1.toString();
        res[1]=res2.toString();
        return res;
    }
}
