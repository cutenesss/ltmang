/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread.clock;

/**
 *
 * @author ADMIN
 */
public class IncNumber{
    int number;
    
    public synchronized void incHS(int s){
        this.number = s;
    }
    
    
}
