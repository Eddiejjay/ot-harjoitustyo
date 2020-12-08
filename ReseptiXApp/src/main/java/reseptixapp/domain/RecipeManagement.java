/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import reseptixapp.dao.DatabaseRecipeDao;


/**
 *
 * @author mazeero
 */
public class RecipeManagement {

    public DatabaseRecipeDao database;

    
    public RecipeManagement(DatabaseRecipeDao database) {

        this.database = database;
    }
    
    public  Recipe createRecipe(String name, String instruction) {
        Recipe recipe = new Recipe(name, instruction); 
        database.addRecipeToDatabase(name, instruction);
        // tarkastele tämä vielä miten toimi  alla 
        return recipe;
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

   



