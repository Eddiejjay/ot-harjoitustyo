/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.ui;



import domain.Recipe;
import domain.RecipeManagement;
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
    
private RecipeManagement recipeManagement = new RecipeManagement(); 

    @Override
    public void start(Stage window) {
       window.setTitle("ReseptiX");{
        
  //HOME näkymä komponentit
       Button addRbutton = new Button ("Lisää resepti");
          addRbutton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       Button button2 = new Button("VasenNappi");
          button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        Label select = new Label("Valitse resepti");
          
    
  // Lisää resepti- näkymä komponentit 
       Button backButton = new Button("Back");
          backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       Button addRecipe = new Button("Lisää resepti");
          addRecipe.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
       TextField newRecipeText = new TextField("");
          newRecipeText.setPrefWidth(100);
          newRecipeText.setPrefHeight(200);
       TextField recipeName = new TextField("");
          
       //Single resepti page komponentit      
       Label foodName = new Label ("Kaalilaatikko");
       Label recipeText = new Label("3 kiloa kaalia, 13 g jauhelihaa, 15 hyppystä suolaa");
       Button backButton2 = new Button("back");
       

        // home näkymän asettelu
       BorderPane borderPane = new BorderPane();
          borderPane.setBottom(addRbutton);
          borderPane.setTop(new Label("Reseptit"));
          borderPane.setRight(select);
          VBox vboxRecepies = new VBox();
          borderPane.setCenter(vboxRecepies);
          
          
          
      //lisää resepti näkymän asettelu
       BorderPane borderPane2 = new BorderPane();
        HBox hbox = new HBox();
           hbox.getChildren().add(backButton);
           hbox.getChildren().add(new Label("Uusi Resepti"));
        VBox vbox = new VBox();
        HBox nameAndField = new HBox();
           nameAndField.getChildren().add(new Label("Ruoan nimi"));
           nameAndField.getChildren().add(recipeName);
        HBox writeRecipeHere = new HBox();
            writeRecipeHere.getChildren().add(new Label("Kirjoita resepti tähän"));
            writeRecipeHere.getChildren().add(newRecipeText);
            vbox.getChildren().add(nameAndField);
            vbox.getChildren().add(writeRecipeHere);
        borderPane2.setTop(hbox);
        borderPane2.setCenter(vbox);
        borderPane2.setBottom(addRecipe);
        
      //yhden reseptin asettelu
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
            newRecipeText.setText("");
            recipeName.setText("");
           
           window.setScene(home);
       });
   
       
       backButton2.setOnAction((event) ->{
            window.setScene(home);
            
        });
       
    
       
       addRecipe.setOnAction((event)->{
          String instruction = newRecipeText.getText();
          String name = recipeName.getText();
          recipeManagement.createRecipe(name, instruction);
          Button recipeButton = new Button(name);
          vboxRecepies.getChildren().add(recipeButton);
           recipeName.setText("");
           newRecipeText.setText("");
           
          
          window.setScene(home);
         
          
       });
       
                   
      
        
        
       
        window.setScene(home);
        window.show();
    }}

    public static void main(String[] args) {
        launch(ReseptiXUi.class);
    }
} 
        
