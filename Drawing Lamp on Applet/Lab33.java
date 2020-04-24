/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Create an applet that makes use of the Graphics class drawing method
*/

package lab3.pkg3;

/**
 *
 * @author Nada
 */

import java.applet.*;
import java.awt.*;

public class Lab33  extends Applet
{

   @Override
   public void paint(Graphics g)
   {
       //base oval
       g.setColor(Color.YELLOW);
       g. fillOval(100, 50, 180, 40); // x,y,width,height 
       g.setColor(Color.black);
       g. drawOval(100, 50, 180, 40); // x,y,width,height 
       
       // 2 lines x1,y1,x2,y2
       g.drawLine(100, 70, 42,190);// left 
       g.drawLine(280, 70, 339,190);// right 
       
       // Arc x,y,width,height,startangle,arcangle
        g.drawArc(43, 170,295,40,180,180);// right 
       
       // middle oval
       g.setColor(Color.YELLOW);
       g.fillOval(165, 110, 50, 70); // x,y,width,height 
       g.setColor(Color.black);
       g. drawOval(165, 110, 50, 70); // x,y,width,height 
       
       //right oval
       g.setColor(Color.YELLOW);
       g. fillOval(120, 120, 30, 50); // x,y,width,height
       g.setColor(Color.black);
       g. drawOval(120, 120, 30, 50); // x,y,width,height 
       
       //left oval
       g.setColor(Color.YELLOW);
       g.fillOval(230, 120, 30, 50); // x,y,width,height 
       g.setColor(Color.black);
       g.drawOval(230, 120, 30, 50); // x,y,width,height 
       
       
       // 2 lines x1,y1,x2,y2
       g.drawLine(180,210, 160,270);// left 
       g.drawLine(200,210, 215,270);// right 
       
       //Rect
       g.drawRect(90, 270, 200,15); // x,y,width,height 
   }
    
}
