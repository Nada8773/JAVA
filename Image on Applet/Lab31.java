/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Create an applet that loads and displays an image on it (.jpg or .gif).
• Scale the image to fit inside the applet if it is bigger than 
  the applet’s boundaries.
*/

package lab3.pkg1;
import java.applet.*;
import java.awt.*;

/**
 *
 * @author Nada
 */
public class Lab31 extends Applet{

    Image pic;
    
    @Override
    public void init()
    {
      pic=getImage(getDocumentBase(),"image.jpg");  
    }
    @Override
    public void paint(Graphics g)
    {
        Dimension d;
        d = new Dimension();
        d.getSize();
        int w=d.width;
        int h=d.height;
        g.drawImage(pic, w, h,this);
    }
    
}
