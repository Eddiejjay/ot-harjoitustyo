package ReseptixAppTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import reseptixapp.domain.Recipe;
import reseptixapp.domain.RecipeManagement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reseptixapp.dao.DatabaseMenuDao;
import reseptixapp.dao.DatabaseRecipeDao;

/**
 *
 * @author mazeero
 */
public class RecipeManagementTest {
       private  RecipeManagement recipeManagement;
         private DatabaseRecipeDao database;
         private DatabaseMenuDao menuDao;
       
    
    public RecipeManagementTest() {
        
    }
   
    @Before
    public void setUp() {
 
        database = new DatabaseRecipeDao("junitTest.db");
        recipeManagement = new RecipeManagement(database);
        menuDao = new DatabaseMenuDao("junitTest.db");
        menuDao.deleteMenusFromDatabase();
        database.deleteRecipesFromDatabase();
        
        
    }
    
    
    @Test
    public void createRecipeAddsRecipeToList() {
       
    
        
        recipeManagement.createRecipe("Kaalilaatikko", "23 kiloa kaalia");
        recipeManagement.createRecipe("pullaa", "23 kiloa kaalia");
        int vastaus = database.getAllRecipes().size();
        assertEquals(2, vastaus);
    }
   
    @Test 
        public void getRandomReturnsRecipe() {
             recipeManagement.createRecipe("Kaalilaatikko", "23 kiloa kaalia");
             Recipe recipe = new Recipe("Kaalilaatikko", "23 kiloa kaalia");
      
             Recipe recipe2 = recipeManagement.getRandom();
          
              assertEquals(recipe.getName(), recipe2.getName());
            
        }
   

   
}

