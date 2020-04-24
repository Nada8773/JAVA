/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.pkg2_chatclient;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Nada
 */
public class Lab62_ChatClient extends Thread {

    Socket s;
    DataInputStream dis;
    PrintStream ps;
     JTextArea ta;
      JTextField tf;
      Thread th;
      int flag=0;
  static Vector<Lab62_ChatClient> clients =new Vector<Lab62_ChatClient>();
    /**
     * ****************** constructor **********
     */
    public Lab62_ChatClient() {

        try {
            th = new Thread(this);
            GUI gui = new GUI();
            gui.setSize(600, 300);
            gui.setVisible(true);
            s = new Socket("localhost", 5005);
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            th.start();
           
        } catch (IOException ex) {
            Logger.getLogger(Lab62_ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ***************** GUI inner Class *******
     */
    public class GUI extends JFrame {

        public GUI() {
            this.setLayout(new FlowLayout());
            ta = new JTextArea(5, 35);
            JScrollPane scroll = new JScrollPane(ta);
            scroll.setViewportView(ta);
            tf = new JTextField(30);
            JButton okButton = new JButton("Send");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    
                    ps.println(tf.getText());
                    tf.setText(" ");
                   
                }
            });
            add(scroll);
            add(tf);
            add(okButton);
          
        }
    }

    /* Run Thread **********************************/
    @Override
    public void run()
   {
       while(true)
          {

           try {
               String str=dis.readLine();
               ta.append(str);
               ta.append("\n");
           } catch (IOException ex) {
               Logger.getLogger(Lab62_ChatClient.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
               
              
    
           
               
       
          }
   }
     
    
    /**
     * **************** Main **************************************8
     *
     * @param args **************
     */
    public static void main(String[] args) {
        new Lab62_ChatClient();
    }

}
