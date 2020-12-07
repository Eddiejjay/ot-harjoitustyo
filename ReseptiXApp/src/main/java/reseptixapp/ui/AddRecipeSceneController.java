/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class AddRecipeSceneController implements Initializable {
    private RecipeManagement recipeManagement;
    private FXMLUI application;
    private AllRecipesController allRecipesController;
    private CreateMenuSceneController createMenuSceneController;
    
    public Button add;
    public TextField newRecipeName;
    public TextArea newRecipeInstruction;
 

    
    
    public void setRecipeManagement(RecipeManagement recipeManagement) {
        this.recipeManagement = recipeManagement;
    }
    public void setApplication(FXMLUI application) {
        this.application = application;
    }
    public void setAllRecipesController(AllRecipesController allRecipesController){
        this.allRecipesController = allRecipesController;
    }
    public void setCreateMenuSceneController(CreateMenuSceneController createMenuSceneController){
        this.createMenuSceneController = createMenuSceneController;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newRecipeInstruction.setPromptText("Ingredients and instructions here...");
    }    
    
    
    
    public void addButtonClicked(){
       String name = newRecipeName.getText();
       String instruction = newRecipeInstruction.getText();
       recipeManagement.createRecipe(name, instruction);
       allRecipesController.updateRecipesListView();
    
      
       
       newRecipeName.setText("");
       newRecipeInstruction.setText("");
       newRecipeInstruction.setPromptText("Ingredients and instructions here...");
       createMenuSceneController.fillComboBox();
       application.setAllRecipesScene();
         
    }
    
    
    
 
}
  
