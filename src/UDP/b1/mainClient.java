/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.b1;

/**
 *
 * @author Cuteness
 */
public class mainClient {
    public static void main(String[] args) {
        Client c = new Client();
        c.sending();
        c.listening();
    }
   
}
