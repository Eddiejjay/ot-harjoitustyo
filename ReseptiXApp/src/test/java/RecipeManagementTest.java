/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.RecipeSaveTest;
import domain.Recipe;
import domain.RecipeManagement;
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
       private RecipeSaveTest recipeDao;
       private  RecipeManagement recipeManagement;
    
    public RecipeManagementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        recipeDao = new RecipeSaveTest();
        recipeManagement = new RecipeManagement(recipeDao);
    }
    
    @After
    public void tearDown() {
    }
    
      @Test
    public void hello() {}
    
    @Test
    public void createRecipeAddsRecipeToList(){
       
    
        
        recipeManagement.createRecipe("Kaalilaatikko", "23 kiloa kaalia");
        recipeManagement.createRecipe("pullaa", "23 kiloa kaalia");
        int vastaus = recipeDao.getAll().size();
        assertEquals(2, vastaus);
    }
   
    @Test 
        public void getRandomReturnsRecipe(){
             recipeManagement.createRecipe("Kaalilaatikko", "23 kiloa kaalia");
             Recipe recipe2 = new Recipe("Kaalilaatikko", "23 kiloa kaalia");
      
             Recipe recipe = recipeManagement.getRandom();
          
              assertEquals(recipe.getName(), recipe2.getName());
            
        }
   

   
}

