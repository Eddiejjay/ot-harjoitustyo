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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import reseptixapp.domain.Menu;
import reseptixapp.domain.Recipe;
import reseptixapp.domain.RecipeManagement;
import reseptixapp.ui.FXMLUI;

/**
 * FXML Controller class
 *
 * @author mazeero
 */
public class MenuSceneController implements Initializable {
    private RecipeManagement recipeManagement;
    private FXMLUI application;
    private AllRecipesController allRecipesController;
    private SingleRecipeSceneController singleRecipeSceneController;
    private Menu menu;
    
    public Button backButton;
    public Label menuPageNameField;
    public Button mondayRecipe;
    public Button tuesdayRecipe;
    public Button wednesdayRecipe;
    public Button thursdayRecipe;
    public Button fridayRecipe;
    public Button saturdayRecipe;
    public Button sundayRecipe;
   
 
           
    public void setMenu(Menu menu){
        this.menu = menu;
        
    }

    
    public void setRecipeManagement(RecipeManagement recipeManagement) {
        this.recipeManagement = recipeManagement;
    }
    public void setApplication(FXMLUI application) {
        this.application = application;
    }
    public void setAllRecipesController(AllRecipesController allRecipesController){
        this.allRecipesController = allRecipesController;
    }
    public void setSingleRecipeSceneController(SingleRecipeSceneController singleRecipeSceneController){
        this.singleRecipeSceneController= singleRecipeSceneController;
    }
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }

    public void backButtonClicked(){
         application.setAllRecipesScene();
        
    }
    
    public void setName(String name){
        this.menuPageNameField.setText(name);
    }
    
    public void mondayRecipeButtonClicked(){
         singleRecipeSceneController.setName(this.menu.getMondayRecipe().getName());
         singleRecipeSceneController.setInstruction(this.menu.getMondayRecipe().getInstruction());
        
        application.setSingleRecipeScene();
        
        
    }
    public void tuesdayRecipeButtonClicked(){
         singleRecipeSceneController.setName(this.menu.getTuesdayRecipe().getName());
         singleRecipeSceneController.setInstruction(this.menu.getTuesdayRecipe().getInstruction());
        
        application.setSingleRecipeScene();
        
        
    }
    public void wednesdayRecipeButtonClicked(){
        singleRecipeSceneController.setName(this.menu.getWednesdayRecipe().getName());
         singleRecipeSceneController.setInstruction(this.menu.getWednesdayRecipe().getInstruction());
        
        application.setSingleRecipeScene();
        
        
    }
    public void thursdayRecipeButtonClicked(){
        singleRecipeSceneController.setName(this.menu.getThursdayRecipe().getName());
         singleRecipeSceneController.setInstruction(this.menu.getThursdayRecipe().getInstruction());
        
        application.setSingleRecipeScene();
        
        
    }
    public void fridayRecipeButtonClicked(){
        singleRecipeSceneController.setName(this.menu.getFridayRecipe().getName());
         singleRecipeSceneController.setInstruction(this.menu.getFridayRecipe().getInstruction());
        
        application.setSingleRecipeScene();
        
        
    }
    public void saturdayRecipeButtonClicked(){
        singleRecipeSceneController.setName(this.menu.getSaturdayRecipe().getName());
         singleRecipeSceneController.setInstruction(this.menu.getSaturdayRecipe().getInstruction());
        
        application.setSingleRecipeScene();
        
        
    }
    public void sundayRecipeButtonClicked(){
        singleRecipeSceneController.setName(this.menu.getSundayRecipe().getName());
         singleRecipeSceneController.setInstruction(this.menu.getSundayRecipe().getInstruction());
        
        application.setSingleRecipeScene();
        
    }
    
    public void initMenuScene(Menu menu){
        this.mondayRecipe.setText(menu.getMondayRecipe().getName());
        this.tuesdayRecipe.setText(menu.getTuesdayRecipe().getName());
        this.wednesdayRecipe.setText(menu.getWednesdayRecipe().getName());
        this.thursdayRecipe.setText(menu.getThursdayRecipe().getName());
        this.fridayRecipe.setText(menu.getFridayRecipe().getName());
        this.saturdayRecipe.setText(menu.getSaturdayRecipe().getName());
        this.sundayRecipe.setText(menu.getSundayRecipe().getName());

        
    }
    
    
    

}
    
    