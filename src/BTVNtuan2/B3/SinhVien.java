/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVNtuan2.B3;

/**
 *
 * @author ADMIN
 */
public class SinhVien {

    private String ten;
    private String maSV;
    private String que;

    public SinhVien(){
        
    }
    
    public SinhVien(String ten, String maSV, String que) {
        this.ten = ten;
        this.maSV = maSV;
        this.que = que;
    } 
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.ten, this.maSV, this.que);
    }
}
