/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Recipe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mazeero
 */
public class RecipeSaveTest {
    private List<Recipe> recipes;
    
   
    public RecipeSaveTest(){
        recipes = new ArrayList<>();
        
    }
    
    public List getAll(){
        return recipes;
        
    }
    private int generateId(){
        return recipes.size();
    }
    
    public Recipe create(Recipe recipe)  {
        recipe.setId(generateId());
        recipes.add(recipe);
        return recipe;
        
   
}}

