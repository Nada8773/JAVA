/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4.pkg1;

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

public class Lab41 extends Applet implements Runnable{

    Thread th;
    int x=10;
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
      if(x==(this.getWidth()))
      {
          x=10;
      }
      else
      {
          x+=10;
      }
          try {
              th.sleep(1000);
          } catch (InterruptedException ex) {
              Logger.getLogger(Lab41.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
  }
  
  @Override
  public void paint(Graphics g)
  {      
      g.drawString("Hello Java", x, 50);
  }
    
}


