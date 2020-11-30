/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import reseptixapp.AddRecipeSceneController;
import reseptixapp.AllRecipesController;
import reseptixapp.SingleRecipeSceneController;
import reseptixapp.dao.RecipeSave;
import reseptixapp.domain.RecipeManagement;

/**
 *
 * @author mazeero
 */
public class FXMLUI extends Application{
    private RecipeSave recipeSave;
    private RecipeManagement recipeManagement;
   
    private Scene AllRecipesScene;
    private Scene AddRecipeScene;
    private Scene SingleRecipeScene;
    private Stage stage;
    
    
    @Override
    public void init() throws Exception {  
    recipeSave = new RecipeSave();
    recipeManagement = new RecipeManagement(recipeSave);
      
    FXMLLoader AllRecipesSceneLoader = new FXMLLoader(getClass().getResource("/fxml/AllRecipesScene.fxml"));
    Parent AllRecipesPane = AllRecipesSceneLoader.load();
    AllRecipesScene = new Scene(AllRecipesPane, 600, 400);
    AllRecipesController allRecipesSceneController = AllRecipesSceneLoader.getController();
    allRecipesSceneController.setRecipeManagement(recipeManagement); 
    allRecipesSceneController.setApplication(this);
  
    
    FXMLLoader AddRecipeSceneLoader = new FXMLLoader(getClass().getResource("/fxml/AddRecipeScene.fxml"));
    Parent AddRecipePane = AddRecipeSceneLoader.load();
    AddRecipeScene = new Scene(AddRecipePane, 600, 400);
    AddRecipeSceneController addRecipesSceneController = AddRecipeSceneLoader.getController();
    addRecipesSceneController.setRecipeManagement(recipeManagement); 
    addRecipesSceneController.setApplication(this);
    addRecipesSceneController.setAllRecipesController(allRecipesSceneController);
    
 
    FXMLLoader SingleRecipeSceneLoader = new FXMLLoader(getClass().getResource("/fxml/SingleRecipeScene.fxml"));
    Parent SingleRecipePane = SingleRecipeSceneLoader.load();
    SingleRecipeScene = new Scene(SingleRecipePane, 600, 400);
    SingleRecipeSceneController singleRecipesSceneController = SingleRecipeSceneLoader.getController();
    singleRecipesSceneController.setRecipeManagement(recipeManagement); 
    singleRecipesSceneController.setApplication(this);
    singleRecipesSceneController.setAllRecipesController(allRecipesSceneController);

    
    
    allRecipesSceneController.setSingleRecipeSceneController(singleRecipesSceneController);

    
    }
    
    
public static void main(String[] args) {
        launch(FXMLUI.class);
    }
    


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
      

    
        stage.setTitle("RespetiX");
        setAllRecipesScene();
//        setSingleRecipeScene();
        stage.show();
       
    }

public void setAddRecipeScene(){
    this.stage.setScene(AddRecipeScene);
  
   
    
}
public void  setAllRecipesScene(){
        this.stage.setScene(AllRecipesScene);

    
}
public void setSingleRecipeScene(){
    this.stage.setScene(SingleRecipeScene);
}

}

     
 




