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

/**
 
 * Reseptien toimintoja käsittelevä luokka ui:in ja tietokannan välillä
 */
public class RecipeManagement {

    private DatabaseRecipeDao database;

    
    public RecipeManagement(DatabaseRecipeDao database) {

        this.database = database;
    }
    /**
    * Uuden reseptin luominen
    *
    * @param name luotavan reseptin nimi
    * @param instruction  luotavan reseptin ainesosat ja ohje  
    * 
    * @return menu palauttaa luodun reseptin
    */
    public  Recipe createRecipe(String name, String instruction) {
        Recipe recipe = new Recipe(name, instruction); 
        database.addRecipeToDatabase(recipe);
        // tarkastele tämä vielä miten toimi  alla 
        return recipe;
    }
   
   /**
    * Satunnaisen reseptin hakeminen
    * 
    * @return satunnainen resepti
    */
    public Recipe getRandom() { 
        Random random = new Random();
        List<Recipe> reseptit = database.getAllRecipes();
     
       
        return  reseptit.get(random.nextInt(reseptit.size()));
    }
   
 /**
    * Kaikkien reseptien hakeminen 
    * @return kaikki reseptit
    */
    public List<Recipe> getAll() {
        return database.getAllRecipes();
             
    }
   
        
}

   



