/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.B1;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Model {
    private float num1;
    private float num2;
    private float res;
    private char option;
    private int count;
    
    public Model(){
        this.num1 = 0;
        this.num2 = 0;
        this.res = 0;
        count=0;
    }
    
    public Model(float n1, float n2, float n3){
        this.num1 = n1;
        this.num2 = n2;
        this.res = n3;
    }
    
    public void setCal(JButton btn, JTextField txt){
        this.option = btn.getText().charAt(0);
        float num = Integer.parseInt(txt.getText());
        count++;
        if(count == 1){
            this.num1 = num;
        }
        if(count == 1){
            this.num2 = num;
            count=0;
            calculate(this.option, this.num1, this.num2);
        }
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public float getRes() {
        return res;
    }

    public void setRes(float res) {
        this.res = res;
    }

    private void calculate(char option, float num1, float num2) {
        switch(option){
            case '+':{
                this.res = num1+num2;
            }
        }
    }
}
