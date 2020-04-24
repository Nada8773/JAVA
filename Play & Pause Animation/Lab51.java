/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.pkg1;


/*
Create an applet that has two buttons one to let
ball star moving randomly and one to pause this
ball moving.

*/
import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Nada
 */
public class Lab51 extends Applet implements Runnable {

    Button button_start;
    Button button_pause;

    int flag = 0;
    Thread th;
    int x = 0;
    int y = 100;
    int flag_x = 0;
    int flag_y = 0;

    @Override
    public void init() {
        th = new Thread(this);

        button_start = new Button("Start");
        button_pause = new Button("Pause");

        /**
         * ********************* Button increament ***********
         */
        button_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == 0) {
                    th.start();
                    flag=1;
                } else {
                    th.resume();
                }

            }
        });

        add(button_start);

        /**
         * ******************** Button Decreament *************
         */
        button_pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                 if(flag==1)
                {
                    th.suspend();
                }
     
                

            }
        });
        add(button_pause);

    }

    @Override
    public void run() {
        while (true) {
            repaint();
            if (x >= this.getWidth()) {
                flag_x = 0;
            } else if (x <= 0) {
                flag_x = 1;
            }
            if (y >= this.getHeight()) {
                flag_y = 0;
            } else if (y <= 0) {
                flag_y = 1;
            }
            if (flag_x == 0) {
                x -= 1;

            } else {
                x += 1;
            }
            if (flag_y == 0) {
                y -= 1;
            } else {
                y += 1;
            }

            try {
                th.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lab51.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void paint(Graphics g) {

        g.drawOval(x, y, 10, 10);
    }

}
