/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import reseptixapp.domain.Recipe;
import reseptixapp.domain.RecipeManagement;
import reseptixapp.ui.FXMLUI;

/**
 * FXML Controller class
 *
 * @author mazeero
 */
public class AllRecipesController implements Initializable {
    private RecipeManagement recipeManagement;
    private FXMLUI application;
    private SingleRecipeSceneController singleRecipeSceneController;
    public Button test;
    public Button addRecipe;
    public Button letsCookButton;
    public Button surpriseButton;
    public ListView<Recipe> listView;
    
 
    
    
    
    public void setRecipeManagement(RecipeManagement recipeManagement) {
        this.recipeManagement = recipeManagement;
    }
    public void setApplication(FXMLUI application) {
        this.application = application;
    }
     public void setSingleRecipeSceneController(SingleRecipeSceneController singleRecipeSceneController){
        this.singleRecipeSceneController= singleRecipeSceneController;
    }
    
    public void testButtonClicked(){
        System.out.println("Toimiiko!");
        addToListView();
    }
    
    public void addRecipeClicked() {
        application.setAddRecipeScene();
    
        
    }
    
   public ListView<Recipe> createListView(){
        this.listView.setItems(createOlist());     
           return this.listView;        

   }
    
    
    public  ObservableList<Recipe> createOlist(){
           ObservableList<Recipe> recipesOl = FXCollections.observableArrayList(recipeManagement.getAll());
             return recipesOl;
       }
    
    
    public void updateListView(){
        
        createListView();
 
        
        this.listView.setCellFactory(param -> new ListCell<Recipe>() {
            
              @Override
           protected void updateItem(Recipe item, boolean empty) {
               super.updateItem(item, empty);

               if (empty || item == null || item.getName() == null) {
                   setText(null);
              } else {
                   setText(item.getName());
               }        
   }});
        
    }
    public void letsCookButtonClicked(){  
         Recipe resepti;
          resepti = this.listView.getSelectionModel().getSelectedItem();
                  
                
                
                singleRecipeSceneController.setName(resepti.getName());
                singleRecipeSceneController.setInstruction(resepti.getInstruction());
                
                application.setSingleRecipeScene();
                
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
      
    }    
    
    public void addToListView(){
        //this.listView.getItems().add("Perse");
    }
       public void surpriseButtonClicked(){
        Recipe resepti;
            resepti = recipeManagement.getRandom();
            
             singleRecipeSceneController.setName(resepti.getName());
             singleRecipeSceneController.setInstruction(resepti.getInstruction());
                
             application.setSingleRecipeScene();
            
            
    }
    
   
    
          
}


