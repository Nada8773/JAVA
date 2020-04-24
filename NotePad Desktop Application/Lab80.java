/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.pkg8.pkg0;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Nada
 */


public class Lab80 extends Application{

    public String text;
    public static int flag_saveText=0;
    @Override
    public void start(Stage stage) throws Exception {
        
       
        /************************** GUI javaFx ******************************/
        
        MenuBar menuBar =new MenuBar();
        
        /************************* File Menu ***********/
        Menu file =new Menu("File");
        MenuItem newItem =new MenuItem("New");
        MenuItem openItem =new MenuItem("Open");
        MenuItem saveItem =new MenuItem("Save");
        MenuItem exitItem =new MenuItem("Exit");

        file.getItems().addAll(newItem,openItem,saveItem,exitItem);
        
        /************************** Edit Menu ******************/
        Menu edit =new Menu("Edit");
        MenuItem undoItem =new MenuItem("Undo");
        MenuItem cutItem =new MenuItem("Cut");
        MenuItem copyItem =new MenuItem("Copy");
        MenuItem pasteItem =new MenuItem("Paste");
        MenuItem deleteItem =new MenuItem("Delete");
        MenuItem selectAllItem =new MenuItem("Select All");
        
        edit.getItems().addAll(undoItem,cutItem,copyItem,pasteItem,deleteItem,selectAllItem);

       /**************************** Help Menu *******/
        Menu help =new Menu("Help");
        MenuItem aboutItem =new MenuItem("About Notepad");   
        help.getItems().addAll(aboutItem);

        /******************************** Text *************************/
        TextArea textArea = new TextArea();
        

       /********************add all bar menu (file - Edit - Help ) ********************/
      FlowPane root =new FlowPane();
      BorderPane borderPane =new BorderPane();
      
       menuBar.getMenus().addAll(file,edit,help);
      root.getChildren().addAll(menuBar);
      
      borderPane.setCenter(textArea);
      borderPane.setTop(root);
     
      Scene scene =new Scene(borderPane,300,400);
      stage.setTitle("Notepad");
      stage.setScene(scene);
      stage.show();
      
      /*****************************************************************************/
      
      
      
      /*********************** Exception Handler *****/
      /***************************** file **************************************************/
      /**************** open Item **************/     
  openItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        
       BufferedReader bufferedReader = null;
       String st; 
        FileChooser file_chooser = new FileChooser(); 
 
       File file = file_chooser.showOpenDialog(stage); 
      
      
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab80.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
        try {
            textArea.clear();
            while ((st = bufferedReader.readLine()) != null)
            {
                textArea.appendText(st);
                textArea.appendText("\n");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Lab80.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 }
       
});
   
      
    /**************** save Item **************/     
  saveItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        flag_saveText=1;
           String text_save = null;
           FileChooser fileChooser = new FileChooser();
           FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
           fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(stage);
            PrintWriter writer = null;

     if (file != null) {
                
               try {
                   writer = new PrintWriter(file);
                   writer.println(textArea.getText());
                   writer.close();

               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Lab80.class.getName()).log(Level.SEVERE, null, ex);
               }
             
            }
        
    }
  });
        
      
    /**************** new Item **************/     
  newItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        textArea.clear();
    }
});    
      
  /**************** exit Item **************/     
  exitItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        System.exit(0);
    }
}); 
  
    /************************************************** Edit ******************************/
  
      /**************** cut Item **************/     
  cutItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        textArea.cut();  
    }
}); 
        /**************** paste Item **************/     
  pasteItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        textArea.paste();
    }
}); 
          /**************** copy Item **************/     
  copyItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        textArea.copy();
    }
}); 
  
            /**************** delete Item **************/     
  deleteItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        textArea.deleteNextChar();
    }
}); 
  
              /**************** selectAll Item **************/     
  selectAllItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        textArea.selectAll();
    }
}); 
  
        /**************** undo Item **************/     
  undoItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        textArea.undo();
    }
}); 
  
  /***************************** help ***************************/
    aboutItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About Notepad");
        alert.setHeaderText(null);
        alert.setContentText("@2019 \n created by Nada");

alert.showAndWait();
    }
}); 
      
}
    
    /*********************** main  *******************/
        public static void main(String[] args) {
        Application.launch(args);
    }

}
