/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5.pkg0;

/*
Create an applet that has two buttons one to
increment the counter value and one to decrement
this value.
*/
import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Nada
 */
public class Lab50 extends Applet
{

    int x=0;
    Button button_inc;
    Button button_dec;

    
    @Override
  public void init()
  {
      button_inc=new Button("increase");
      button_dec=new Button("decrease");
      
      button_inc.addActionListener( new ActionListener()
                                     {
                                  @Override
                                  public void actionPerformed(ActionEvent e)
                                       {
                                           if(x<10) 
                                              {
                                                   x++;
                                                   repaint();
                                              }
                                              
                                           else x=10;
                                           
             
                                        } 
                                     });
    
       add(button_inc);
            button_dec.addActionListener( new ActionListener()
                                     {
                                  @Override
                                  public void actionPerformed(ActionEvent e)
                                       {
                                           if(x>0)
                                                {
                                                  x--;
                                                  repaint();
                                                }
                                               
                                           else 
                                               {
                                                   x=0;
                                               }
                                             
                                           
             
                                        }   
                                       });
              
              
              
              add(button_dec);
             
      
  
      
      
  }
  
  
  @Override
  public void paint(Graphics g)
  {
      g.drawString(Integer.toString(x),50,100);
  }
    
}
