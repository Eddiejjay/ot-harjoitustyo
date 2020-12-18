/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 
 * @author mazeero
 */
public class Menu {
    private Integer id;
    private String name;
    private List<Recipe> recipes;
   
    public Menu(String name, List<Recipe> recipes) {
        this.name = name; 
        this.recipes = recipes; 
  
    }
    
    public Menu(Integer id, String name, List<Recipe> recipes) {
        this.name = name; 
        this.recipes = recipes; 
        this.id = id;
    
    }
    
    public String getName() {
        return this.name;
    }
    @Override
public String toString() {
        return this.getName();
    }

    public List<Recipe> geRecipes() {
       return this.recipes;
    }

public Integer getId(){
    return this.id;
}
public void setId(Integer id){
    this.id = id;
}
public Recipe getMondayRecipe(){
    return recipes.get(0);
    
}
public Recipe getTuesdayRecipe(){
    return recipes.get(1);
}

public Recipe getWednesdayRecipe(){
    return recipes.get(2);
}

public Recipe getThursdayRecipe(){
    return recipes.get(3);
}

public Recipe getFridayRecipe(){
    return recipes.get(4);
}

public Recipe getSaturdayRecipe(){
    return recipes.get(5);
}

public Recipe getSundayRecipe(){
    return recipes.get(6);
}
}