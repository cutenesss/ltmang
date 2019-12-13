/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.b3;

import java.io.Serializable;

/**
 *
 * @author Cuteness
 */
public class Student implements Serializable{
    int id;
    String code;
    float gpa;
    String gpaLetter;

    public Student(String code) {
        this.code = code;
    }

    
    public Student(int id, String code, float gpa) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getGpaLetter() {
        return gpaLetter;
    }

    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }
}
