/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4.pkg2;

/**
 *
 * @author Nada
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.applet.*;
import java.awt.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nada
 */

public class Lab42 extends Applet implements Runnable{

    Thread th;
    int x=0;
    int y=100;
    int flag_x=0;
    int flag_y=0;
  @Override
  public void init()
  {
      th=new Thread(this);
      th.start();
  }
  
  @Override
  public void run()
  {
      while(true)
      {
      repaint();
      if(x >=this.getWidth())
      {
          flag_x=0;
      }
      else if(x<=0)
      {
          flag_x=1;
      }
      if(y>=this.getHeight() )
      {
          flag_y=0;         
      }
      else if(y<=0)
      {
          flag_y=1;
      }
      if(flag_x ==0  )
      {
          x-=1;
      
      }
      else
      {
          x+=1;
      }
      if( flag_y==0)
      {
          y-=1;
      }
      else
      {
          y+=1;
      }
      
          try {
              th.sleep(10);
          } catch (InterruptedException ex) {
              Logger.getLogger(Lab42.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
  }
  
  @Override
  public void paint(Graphics g)
  {
      
      g.drawOval(x,y,10,10);
  }
    
}
