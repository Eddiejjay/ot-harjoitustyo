/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReseptixAppTests;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reseptixapp.dao.DatabaseConnection;
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
  private RecipeManagement recipeManagement;
    private DatabaseRecipeDao databaseRecipeDao;
    private DatabaseMenuDao databaseMenuDao;
    private DatabaseConnection databaseConnection;
    private Connection connection;
    private MenuManagement menuManagement;
       
    
    public MenuManagementTest() {
    }
    
  
    @Before
    public void setUp() {
  
    databaseConnection = new DatabaseConnection("testi.db");
    this.connection =  (Connection) databaseConnection.connect();
    databaseRecipeDao = new DatabaseRecipeDao(this.connection);
    databaseMenuDao = new DatabaseMenuDao(this.connection);
    recipeManagement = new RecipeManagement (databaseRecipeDao);
    menuManagement = new MenuManagement (databaseMenuDao);
        
    }
   
   @After 
    
  public void delete(){
       databaseMenuDao.deleteMenusFromDatabase();
      databaseRecipeDao.deleteRecipesFromDatabase();
        
    }

    
@Test
public void createMenuCreatesMenu(){
 
    for (int i = 0; i < 7 ; i++){
        Recipe recipe = new Recipe("Kaalilaatikko", "14 kg kaalia");
        databaseRecipeDao.addRecipeToDatabase(recipe);
    }

   menuManagement.createMenu("Jorman KaaliMenu",databaseRecipeDao.getAllRecipes());
   
   int menusSize = menuManagement.getAllMenus().size();
   assertEquals(1, menusSize);
   
}



}
