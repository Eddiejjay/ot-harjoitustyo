/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mazeero
 */
public class RecipeManagement {
    public Map<Integer,Recipe> recipes;
    
    public RecipeManagement(){
        recipes = new HashMap<>();
    }
    
   public void createRecipe(String name, String instruction){
       int id = recipes.size() +1;
       this.recipes.put(id,new Recipe(id,name,instruction));
       
  
   }
   public Map getAll(){
       return this.recipes;
   }
    public Recipe getOne(int id){
      return recipes.get(id);
    }
}