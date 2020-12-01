/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import reseptixapp.domain.Recipe;
import reseptixapp.domain.RecipeManagement;
import reseptixapp.ui.FXMLUI;

/**
 * FXML Controller class
 *
 * @author mazeero
 */
public class CreateMenuSceneController implements Initializable {
    private RecipeManagement recipeManagement;
    private FXMLUI application;
    private AllRecipesController allRecipesController;
    
    public ComboBox<Recipe> comboBox;
    public Button back;
  
 

    
    
    public void setRecipeManagement(RecipeManagement recipeManagement) {
        this.recipeManagement = recipeManagement;
    }
    public void setApplication(FXMLUI application) {
        this.application = application;
    }
    public void setAllRecipesController(AllRecipesController allRecipesController){
        this.allRecipesController = allRecipesController;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
     
    }    
  
       public void backButtonClicked(){
        application.setAllRecipesScene();
   
    
       }
    
public void fillComboBox(){
    comboBox.setItems(allRecipesController.createOlist());
    
//    this.comboBox.setCellFactory(param -> new ListCell<Recipe>() {
//            
//              @Override
//           protected void updateItem(Recipe item, boolean empty) {
//               super.updateItem(item, empty);
//
//               if (empty || item == null || item.getName() == null) {
//                   setText(null);
//              } else {
//                   setText(item.getName());
//               }       
//               
//   }});
    
    
    
}
  
         
    
 
}
  
