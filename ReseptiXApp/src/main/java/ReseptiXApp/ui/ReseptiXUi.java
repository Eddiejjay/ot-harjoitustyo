/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReseptiXApp.ui;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ReseptiXUi extends Application {

    @Override
    public void start(Stage ikkuna) {
       ikkuna.setTitle("Reseptit");{
        
       Label text= new Label("testikenttä");
       Button button = new Button ("Lisää resepti");
       ScrollPane scrollPane = new ScrollPane();
    
      

        //asettelu 

       BorderPane asettelu = new BorderPane();
      asettelu.setBottom(button);
      asettelu.setTop(new Label("Reseptit"));
      asettelu.setCenter(scrollPane);
      asettelu.setRight(text);
      
        Scene nakyma = new Scene(asettelu);
        
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }}

    public static void main(String[] args) {
        launch(ReseptiXUi.class);
    }
}