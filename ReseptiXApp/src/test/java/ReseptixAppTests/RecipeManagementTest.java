package ReseptixAppTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import reseptixapp.dao.RecipeSave;
import reseptixapp.domain.Recipe;
import reseptixapp.domain.RecipeManagement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mazeero
 */
public class RecipeManagementTest {
       private RecipeSave recipeDao;
       private  RecipeManagement recipeManagement;
    
    public RecipeManagementTest() {
        
    }
   
    @Before
    public void setUp() {
        recipeDao = new RecipeSave();
        recipeManagement = new RecipeManagement(recipeDao);
    }
    
    
    @Test
    public void createRecipeAddsRecipeToList() {
       
    
        
        recipeManagement.createRecipe("Kaalilaatikko", "23 kiloa kaalia");
        recipeManagement.createRecipe("pullaa", "23 kiloa kaalia");
        int vastaus = recipeDao.getAll().size();
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
