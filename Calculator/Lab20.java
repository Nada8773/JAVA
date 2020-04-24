/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
Application that carries out the
functionality of a basic calculator (addition, subtraction,
multiplication, and division).
• The program, for example, should be run by typing the
following at the command prompt:
java Calc 70 + 30

*/

package lab2.pkg0;

/**
 *
 * @author Nada
 */
public class Lab20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int res;
         Calc c=new Calc();
         res=Calc.sum_op(args);
         
         System.out.println(res);
         
        
        
    }
    
}
