/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.B1;

/**
 *
 * @author ADMIN
 */
public class Controller {
   Model cal;
   public Controller(){
       new Model();
   }
   
   public Controller(Model m){
       this.cal = m;
   }
   
   public Controller(float n1, float n2, String t){
       String add = "+";
       String sub = "-";
       String mul = "*";
       String div = "/";
       if( t.equals(add)){
           float n3= n1+n2;
           this.cal = new Model(n1, n2,n3);
           
       }
       if( t.equals(sub)){
           float n3= n1-n2;
           this.cal = new Model(n1, n2,n3);
           
       }
       if( t.equals(mul)){
           float n3= n1*n2;
           this.cal = new Model(n1, n2,n3);
           
       }
       if( t.equals(div)){
           float n3= n1/n2;
           this.cal = new Model(n1, n2,n3);
           
       }
   }
}
