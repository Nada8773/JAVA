/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1.pkg2;

/**
 *
 * @author Nada
 */
public class Lab12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Complex c=new Complex();
        
        c.SetVal(5, 6);
       
        System.out.print(c.getReal());
        System.out.print('+');
        System.out.print(c.getImag());
        System.out.print('i');
        
    }
    
}
