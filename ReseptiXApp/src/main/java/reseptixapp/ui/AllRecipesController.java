/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.ui;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import reseptixapp.domain.Menu;
import reseptixapp.domain.MenuManagement;
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
    private MenuManagement menuManagement;
    private FXMLUI application;
    private SingleRecipeSceneController singleRecipeSceneController;
    private MenuSceneController menuSceneController;
    
    
 
    public Button addRecipe;
    public Button letsCookButton;
    public Button surpriseButton;
    public Button makeAmenuButton;
    public ListView<Recipe> listView;
    public ListView<Menu> pickMenuListView;
    public Button pickMenuButton;
     
    
 
    
    
    
public void setRecipeManagement(RecipeManagement recipeManagement) {
    this.recipeManagement = recipeManagement;
    }
    
public void setMenuManagement(MenuManagement menuManagement) {
    this.menuManagement = menuManagement;
     }
     
public void setApplication(FXMLUI application) {
    this.application = application;
    }
public void setSingleRecipeSceneController(SingleRecipeSceneController singleRecipeSceneController){
    this.singleRecipeSceneController= singleRecipeSceneController;
    }
public void setMenuSceneController(MenuSceneController menuSceneController){
    this.menuSceneController= menuSceneController;
 
    }
    
public void addRecipeClicked() {
     application.setAddRecipeScene();
    
 
    }
    
public ListView<Recipe> createRecipesListView(){
    this.listView.setItems(createRecipesOlist());     
    return this.listView;        

   }
    
  
public  ObservableList<Recipe> createRecipesOlist(){
    ObservableList<Recipe> recipesOl = FXCollections.observableArrayList(recipeManagement.getAll());
    return recipesOl;
       }
    
    
public void updateRecipesListView(){
    createRecipesListView();

        
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
   
    public void surpriseButtonClicked(){
    Recipe resepti;
    resepti = recipeManagement.getRandom();
    singleRecipeSceneController.setName(resepti.getName());
    singleRecipeSceneController.setInstruction(resepti.getInstruction());
    application.setSingleRecipeScene();
}
    
    public void makeAmenuButtonClicked(){
    application.setCreateMenuScene();
}
      
    public  ListView<Menu> updatePickMenu(){
    this.pickMenuListView.setItems(createMenusOlist());
    return this.pickMenuListView;
     }
           
    
public ObservableList<Menu> createMenusOlist(){       
    HashMap<String,Menu> menus = menuManagement.getAllMenus();
    ObservableList<Menu> menusOl = FXCollections.observableArrayList(menus.values());
    return menusOl;
      }
    
    public void pickMenuButtonClicked(){
        Menu menu = this.pickMenuListView.getSelectionModel().getSelectedItem();
        menuSceneController.setMenu(menu);
        menuSceneController.setName(menu.getName());
        menuSceneController.initMenuScene(menu);    
        application.setMenuScene();
                
        
    }
   
    

}

