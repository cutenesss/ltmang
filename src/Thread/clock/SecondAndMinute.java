/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread.clock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class SecondAndMinute extends Thread {

    int num;

    public SecondAndMinute(int n) {
        this.num = n;
    }

    @Override
    public void run() {
        while (true) {
            while (this.num < 60) {
                try {
                    this.num++;
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SecondAndMinute.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.num = 0;
        }
    }
}
