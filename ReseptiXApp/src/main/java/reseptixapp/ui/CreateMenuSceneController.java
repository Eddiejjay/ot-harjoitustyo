/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.ui;

import reseptixapp.ui.AllRecipesController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import reseptixapp.domain.MenuManagement;
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
    private MenuManagement menuManagement;
    private FXMLUI application;
    private AllRecipesController allRecipesController;
//    private ArrayList<ComboBox> comboBoxes;
    
    public ComboBox<Recipe> cbMonday;
    public ComboBox<Recipe> cbTuesday;
    public ComboBox<Recipe> cbWednesday;
    public ComboBox<Recipe> cbThursday;
    public ComboBox<Recipe> cbFriday;
    public ComboBox<Recipe> cbSaturday;
    public ComboBox<Recipe> cbSunday;
    
    
    public Button back;
    public Button createMenu;
    public TextField menuName;
    
  
 

    
    
    public void setRecipeManagement(RecipeManagement recipeManagement) {
        this.recipeManagement = recipeManagement;
    }
    public void setMenuManagement(MenuManagement menuManagement) {
        this.menuManagement = menuManagement;
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
    ObservableList<Recipe> list = allRecipesController.createRecipesOlist();
    cbMonday.setItems(list);
    cbTuesday.setItems(list);
    cbWednesday.setItems(list);
    cbThursday.setItems(list);
    cbFriday.setItems(list);
    cbSaturday.setItems(list);
    cbSunday.setItems(list);
   
    
    
}

public void createMenuButtonClicked(){
    
    Recipe recipeMonday = cbMonday.getSelectionModel().getSelectedItem(); 
    Recipe recipeTuesday = cbTuesday.getSelectionModel().getSelectedItem(); 
    Recipe recipeWednesday = cbWednesday.getSelectionModel().getSelectedItem(); 
    Recipe recipeThursday = cbThursday.getSelectionModel().getSelectedItem(); 
    Recipe recipeFriday = cbFriday.getSelectionModel().getSelectedItem(); 
    Recipe recipeSaturday = cbSaturday.getSelectionModel().getSelectedItem(); 
    Recipe recipeSunday = cbSunday.getSelectionModel().getSelectedItem(); 
    
    menuManagement.createMenu(menuName.getText(),recipeMonday, recipeTuesday, recipeWednesday, recipeThursday, recipeFriday, recipeSaturday, recipeSunday);  
    
    
    System.out.println("Testi");
//    System.out.println(menuManagement.getAllMenus());
//    
  allRecipesController.updatePickMenu();
    
    application.setAllRecipesScene();
            
}
  
         
    
 
}
  
