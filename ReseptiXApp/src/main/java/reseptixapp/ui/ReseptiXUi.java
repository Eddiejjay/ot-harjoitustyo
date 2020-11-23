/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.ui;



import dao.RecipeSaveTest;
import domain.Recipe;
import domain.RecipeManagement;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
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
    
    private Scene home;
    private Scene newRecipe;
    private Scene recipe;
    private Scene recipeRandom;
 
    private RecipeSaveTest recipeDao = new RecipeSaveTest();
    private RecipeManagement recipeManagement = new RecipeManagement(recipeDao);
    private ListView<Recipe> listview;
    private Button listViewButton;
    private BorderPane borderPane3;
    private BorderPane borderPaneRandom;
    Button randomButton = new Button("Satunnainen");
 
  
    
    
    @Override
    public void init() throws Exception {
         RecipeSaveTest recipeDao = new RecipeSaveTest();
         RecipeManagement recipeManagement = new RecipeManagement(recipeDao);
        
    }
    

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
       TextArea newRecipeText = new TextArea("");
          newRecipeText.setPrefWidth(100);
          newRecipeText.setPrefHeight(200);
       TextField recipeName = new TextField("");
          
       //Single resepti page kompon//entit      
      
       Button backButton2 = new Button("back");
       

        // home näkymän asettelu
          BorderPane borderPane = new BorderPane();
          borderPane.setBottom(addRbutton);
          borderPane.setTop(new Label("Reseptit"));
          borderPane.setRight(select);
          VBox vboxRecepies = new VBox();
          borderPane.setCenter(vboxRecepies);
          listViewButton = new Button("Valitse");
          
          
          VBox VboxHomeButtons = new VBox();
          VboxHomeButtons.getChildren().addAll(listViewButton,randomButton);
          borderPane.setRight(VboxHomeButtons);
          
          
        
          
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
        Label onnistui = new Label ("");
        borderPane2.setLeft(onnistui);
        
  
       
    
        this.home = new Scene(borderPane,450,300);
        this.newRecipe = new Scene(borderPane2,450,300);
      
        
           //RESEPTI nappien luonti
          
   
        
        
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
       
       // etusivun valitse buttonin toiminta 
      listViewButton.setOnAction((event) ->{   
         Recipe resepti;
       resepti =listview.getSelectionModel().getSelectedItem();
                System.out.println(resepti.getInstruction());
                System.out.println(resepti.getName());
                
                
                    //yhden reseptin asettelu
        borderPane3 = new BorderPane();
       Label foodName = new Label (resepti.getName());
       Label recipeText = new Label(resepti.getInstruction());
        borderPane3.setRight(foodName);
        borderPane3.setCenter(recipeText);
        borderPane3.setTop(backButton2);
        
        this.recipe = new Scene(borderPane3,450,300);
        window.setScene(recipe);
                  });      
        
        
          
        // Satunnainen resepti nappi 
         randomButton.setOnAction((event) ->{   
            Recipe resepti;
            resepti = recipeManagement.getRandom();
            borderPaneRandom = new BorderPane();
            Label foodNameRandom = new Label (resepti.getName());
            Label recipeTextRandom = new Label(resepti.getInstruction());
            borderPaneRandom.setRight(foodNameRandom);
            borderPaneRandom.setCenter(recipeTextRandom);
            borderPaneRandom.setTop(backButton2);
        
           this.recipeRandom = new Scene(borderPaneRandom,450,300);
           window.setScene(recipeRandom);
          
        
        
        
        
        
        
                 
                  });   

       
      
       
       addRecipe.setOnAction((event)->{
             
          String instruction = newRecipeText.getText();
          String name = recipeName.getText();
          recipeManagement.createRecipe(name, instruction);
      
         createListView();
          listview.setCellFactory(param -> new ListCell<Recipe>() {
             
               @Override
            protected void updateItem(Recipe item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
         
            
        });
         
          
         recipeName.setText("");
         newRecipeText.setText("");
           borderPane.setCenter(listview);
          window.setScene(home);
         
          
       });

       
    
        
       
        window.setScene(home);
        window.show();
    }} 
    
    
    

            
               
         public ListView<Recipe> createListView(){
             listview = new ListView(createOlist());
             return listview;
             
         }
          
       
       
       
       public  ObservableList<Recipe> createOlist(){
           ObservableList<Recipe> recipesOl = FXCollections.observableArrayList(recipeDao.getAll());
             return recipesOl;
       }
       
   
    public static void main(String[] args) {
        launch(ReseptiXUi.class);
    }
    
    

} 





  //public Node createButtons(){
//           VBox Vreseptit = new VBox();
//           List<Recipe> reseptit = recipeDao.getAll();
//           
//           for (Recipe recipe:reseptit){
//               Button button = new Button(recipe.getName());
//               Vreseptit.getChildren().add(button);
//               button.setOnAction((event)->{ 
//                 
//                   //Onnistuuko tähän jotenkin setACion jotta painallus vaihtaa näkymää yksittäiseen reseptiin? 
//                   
//               });
//           }
//           
//          return Vreseptit;