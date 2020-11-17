/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.ui;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReseptiXUi extends Application {

    @Override
    public void start(Stage window) {
       window.setTitle("ReseptiX");{
        
  
       Button addRbutton = new Button ("Lisää resepti");
          addRbutton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       Button button2 = new Button("VasenNappi");
          button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       Button selectButton = new Button("Valitse");
          selectButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       ListView listView = new ListView();
          listView.getItems().add("Kaalilaatikko");
          listView.getItems().add("GorillaBurger");
          listView.getItems().add("HappoKalat");
          listView.setPrefWidth(100);
          listView.setPrefHeight(200);
          
         
  
       Button backButton = new Button("Back");
          backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       Button addRecipe = new Button("Lisää resepti");
          addRecipe.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       TextField textField = new TextField("Kirjoita resepti tähän!");
          textField.setPrefWidth(100);
          textField.setPrefHeight(200);

          
            
       Label foodName = new Label ("Kaalilaatikko");
       Label recipeText = new Label("3 kiloa kaalia, 13 g jauhelihaa, 15 hyppystä suolaa");
       Button backButton2 = new Button("back");
       

       BorderPane borderPane = new BorderPane();
          borderPane.setBottom(addRbutton);
          borderPane.setTop(new Label("Reseptit"));
          borderPane.setCenter(listView);
          borderPane.setRight(selectButton);
          
      
       BorderPane borderPane2 = new BorderPane();
        HBox hbox = new HBox();
           hbox.getChildren().add(backButton);
           hbox.getChildren().add(new Label("Uusi Resepti"));
        borderPane2.setTop(hbox);
        borderPane2.setCenter(textField);
        borderPane2.setBottom(addRecipe);
        
      
        BorderPane borderPane3 = new BorderPane();
        borderPane3.setTop(foodName);
        borderPane3.setCenter(recipeText);
        borderPane3.setTop(backButton2);
       
        
        Scene home = new Scene(borderPane,450,300);
        Scene newRecipe = new Scene(borderPane2,450,300);
        Scene recipe = new Scene (borderPane3,450,300);
        
        
        
        addRbutton.setOnAction((event) ->{
            window.setScene(newRecipe);
            
        });
      
        backButton.setOnAction((event)->{
           window.setScene(home);
       });
           
       selectButton.setOnAction((event)->{
            ObservableList selectedIndices = listView.getSelectionModel().getSelectedIndices();
            window.setScene(recipe);
            
           
       });
       
       backButton2.setOnAction((event) ->{
            window.setScene(home);
            
        });
        
        
       
        window.setScene(home);
        window.show();
    }}

    public static void main(String[] args) {
        launch(ReseptiXUi.class);
    }
} 
        
