/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReseptixAppTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reseptixapp.dao.DatabaseMenuDao;
import reseptixapp.dao.DatabaseRecipeDao;

import reseptixapp.domain.Menu;
import reseptixapp.domain.MenuManagement;
import reseptixapp.domain.Recipe;
import reseptixapp.domain.RecipeManagement;

/**
 *
 * @author mazeero
 */
public class MenuManagementTest {
       private DatabaseMenuDao menuDao;
       private MenuManagement menuManagement;
       private DatabaseRecipeDao database;
       private RecipeManagement recipeManagement;
       
    
    public MenuManagementTest() {
    }
    
  
    
 
    @Before
    public void setUp() {
  
        menuDao = new DatabaseMenuDao("junitTest.db");
        database = new DatabaseRecipeDao("junitTest.db");
        menuDao.deleteMenusFromDatabase();
        database.deleteRecipesFromDatabase();
        recipeManagement= new RecipeManagement(database);
        menuManagement = new MenuManagement(menuDao);
        
    }

@Test

public void createMenuCreatesMenu(){
    Recipe recipe1 =  recipeManagement.createRecipe("Kaalilaatikko","14kg kaalia");
    Recipe recipe2 =  recipeManagement.createRecipe("Kaalilaatikko","14kg kaalia");
    Recipe recipe3 =  recipeManagement.createRecipe("Kaalilaatikko","14kg kaalia");
    Recipe recipe4 =  recipeManagement.createRecipe("Kaalilaatikko","14kg kaalia");
    Recipe recipe5 =  recipeManagement.createRecipe("Kaalilaatikko","14kg kaalia");
    Recipe recipe6 =  recipeManagement.createRecipe("Kaalilaatikko","14kg kaalia");
    Recipe recipe7 =  recipeManagement.createRecipe("Kaalilaatikko","14kg kaalia");
     
  
   menuManagement.createMenu("Jorman KaaliMenu", recipe1, recipe2, recipe3, recipe4, recipe5, recipe6, recipe7);
   
   int menusSize = menuManagement.getAllMenus().size();
   assertEquals(1, menusSize);
   
}

}
