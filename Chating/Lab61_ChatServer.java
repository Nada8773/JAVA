/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Create a GUI Desktop Application which you can
use as a simple chatting program interface .
*/

package lab6.pkg1_chatserver;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
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
public class Lab61_ChatServer {
    
    ServerSocket serversocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;
    
    public Lab61_ChatServer()
    {
        try {
            serversocket=new ServerSocket(5005);
            while(true)
            {
                s=serversocket.accept();
                new ChatHandle(s);   
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(Lab61_ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
   

    /************************** main ******************/
    public static void main(String[] args) 
    {
        new Lab61_ChatServer();
    }
    
}
 
/************************ ChatHandler Class **********************/
class ChatHandle extends Thread{
    
    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandle> clients =new Vector<ChatHandle>();

    public ChatHandle(Socket cs) 
     {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            clients.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(ChatHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
     } 
         /******************** run Thread *****************/
  @Override
 public void run()
   {
       while(true)
          {
           try {
               String str=dis.readLine();
               for(ChatHandle ch:clients)
               {
                   ch.ps.println(str);
               }
           } catch (IOException ex) {
               Logger.getLogger(ChatHandle.class.getName()).log(Level.SEVERE, null, ex);
           }
          }
   }
     
   

    
}

   