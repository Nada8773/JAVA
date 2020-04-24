/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.pkg2;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Nada
 */
public class Lab52 extends Applet  {

    Label label;
    Thread th;
    int x = 100;
    int y = 100;

    @Override
    public void init() {
        
 
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("hello  action ");
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    x += 50;
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    x -= 50;
                   repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    y -= 50;
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    y += 50;
                    repaint();
                }
                

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("dsmndsm");
            }

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("dsdhjhjd");
            }

        });

    }



    @Override
    public void paint(Graphics g) {

        g.drawString("Java", x, y);
    }

}
