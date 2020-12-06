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
import reseptixapp.dao.DatabaseRecipeDao;
import reseptixapp.dao.MenuSave;

/**
 *
 * @author mazeero
 */
public class RecipeManagement {
    private RecipeSave recipeDao;
      public DatabaseRecipeDao database;

    
    public RecipeManagement(RecipeSave recipeDao, DatabaseRecipeDao database) {
        this.recipeDao = recipeDao;
        this.database = database;
    }
    
    public Recipe createRecipe(String name, String instruction) {
        Recipe recipe = new Recipe(name, instruction); 
        database.addRecipeToDatabase(name,instruction);
        // tarkastele tämä vielä miten toimi  alla 
        return this.recipeDao.create(recipe);
  
    }
   
   
    public Recipe getRandom() { 
        Random random = new Random();
        List<Recipe> reseptit = database.getAllRecipes();
     
       
        return  reseptit.get(random.nextInt(reseptit.size()));
    }
   
 
    public List<Recipe> getAll() {
        return database.getAllRecipes();
             
    }
   
        
}

   



