/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Recipe;
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
public class RecipeTest {
    private Recipe recipe;
    
    public RecipeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         recipe = new Recipe ("kala", "ongi paljon kaloja ja syö!");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void setNameWorksProperly(){
       
        recipe.setName("Taimen");
       
        
        assertEquals("Taimen", recipe.getName());
        
    }
    
    @Test 
    public void setInstructionWorksProperly(){
        recipe.setInstruction("pilko kala ja syö");
        
        assertEquals("pilko kala ja syö", recipe.getInstruction());
        
        
    }

}
