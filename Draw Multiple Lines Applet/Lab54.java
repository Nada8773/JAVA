/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5.pkg4;

/**
 *
 * @author Nada
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Nada
 */
public class Lab54 extends Applet {

    int x1;
    int y1;
    int x2;
    int y2;
    int flag = 0;
    int  pressed_flag=0;
    int[] arr_x1=new int[10];
    int[] arr_y1=new int[10];
    int[] arr_x2=new int[10];
    int[] arr_y2=new int[10];
    int i=0;
    int j=0;
    @Override
    public void init() {

        /**
         * **************** addMouseListener****************
         */
        this.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {

                
                if (flag == 0) {
                    x1 = e.getX();
                    x2=e.getX();
                    y1 = e.getY();
                    y2=e.getY();
                arr_x1[i]=x1;
                arr_y1[i]=y1;
                arr_x2[i]=x2;
                arr_y2[i]=y2;
                    pressed_flag=1;
                    repaint();
                } else {
                    x2 = e.getX();
                    y2 = e.getY();
                    x1 = e.getX();
                    y1 = e.getY();
                arr_x1[i]=x1;
                arr_y1[i]=y1;
                arr_x2[i]=x2;
                arr_y2[i]=y2;
                    flag=0;
                    repaint();
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
                if( pressed_flag==1)
                {
                x2 = e.getX();
                y2 = e.getY();

                arr_x2[i]=x2;
                arr_y2[i]=y2;
                i++;
                flag = 1;
                repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        /**
         * **************addMouseMotion *********************
         */
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
 
                x2 = e.getX();
                y2 = e.getY();
                             
                arr_x2[i]=x2;
                arr_y2[i]=y2;
                
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });

    }

    @Override
    public void paint(Graphics g) {
      
        for(int j=0;j<10;j++)
        {
        g.drawLine(arr_x1[j], arr_y1[j], arr_x2[j], arr_y2[j]);
        }
    }

}
