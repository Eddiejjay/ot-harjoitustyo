/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    }
    
    @After
    public void tearDown() {
    }
    
      @Test
    public void hello() {}
    
    @Test
    public void createRecipeLisaaReseptinHashMappiin(){
        RecipeManagement recipemanagement = new RecipeManagement();
        
        recipemanagement.createRecipe("Kaalilaatikko", "23 kiloa kaalia");
        String vastaus = recipemanagement.getOne(1).getInstruction();
        assertEquals("23 kiloa kaalia", vastaus);
    }
    
   

   
}

