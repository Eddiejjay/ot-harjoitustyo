/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.RecipeSaveTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mazeero
 */
public class RecipeManagement {
   private RecipeSaveTest recipeDao;
    
    public RecipeManagement(RecipeSaveTest recipeDao){
        this.recipeDao = recipeDao;
       
        
          }
    
   public Recipe createRecipe (String name, String instruction){
         Recipe recipe = new Recipe (name,instruction);
      return this.recipeDao.create(recipe);
  
   }


   
    }



