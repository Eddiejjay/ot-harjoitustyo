/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.domain;

import reseptixapp.dao.RecipeSave;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author mazeero
 */
public class RecipeManagement {
    private RecipeSave recipeDao;
    
    public RecipeManagement(RecipeSave recipeDao) {
        this.recipeDao = recipeDao;
    }
    
    public Recipe createRecipe(String name, String instruction) {
        Recipe recipe = new Recipe(name, instruction); 
        return this.recipeDao.create(recipe);
  
    }
   
    public Recipe getRandom() { 
        Random random = new Random();
        List<Recipe> reseptit = recipeDao.getAll();
     
       
        return  reseptit.get(random.nextInt(reseptit.size()));
    }
   
 

   
}



