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
public class Complex {
    
    private  float real;
    private  float imag;
    
    Complex()
    {
        real=0;
        imag=0;
    }
    
    public void SetVal(float x,float y)
    {
        real=x;
        imag=y;
    }
    public float getReal()
    {
        return real;
    }
    public float getImag()
    {
        return imag;
    }
    
}
