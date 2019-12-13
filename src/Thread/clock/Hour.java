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
public class Hour extends Thread{
    int num;

    public Hour(int n) {
        this.num = n;
    }

    @Override
    public void run() {
        while (true) {
            while (this.num < 24) {
                this.num++;
            }
            this.num = 0;
        }
    }
}
