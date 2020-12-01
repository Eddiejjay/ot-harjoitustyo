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
import reseptixapp.dao.MenuSave;

/**
 *
 * @author mazeero
 */
public class RecipeManagement {
    private RecipeSave recipeDao;
//    private MenuSave menuDao;
    
      public RecipeManagement(RecipeSave recipeDao) {
       this.recipeDao = recipeDao;
//    
//    }
//    public RecipeManagement(RecipeSave recipeDao, MenuSave menuDao){
//        this.recipeDao = recipeDao;
//        this.menuDao = menuDao;
    
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
   
 
    public List<Recipe> getAll(){
       return recipeDao.getAll();
             
    }
    
//    public Menu createMenu(String name, Recipe mon, Recipe tue, Recipe wed, Recipe thu, Recipe fri,Recipe sat, Recipe sun){
//       Menu menu = new Menu(name, mon, tue, wed, thu, fri, sat, sun);
//        return menuDao.createMenu(name,menu);
//     
//       
//        
//    }
//
//public Map<String,Menu> getAllMenus(){
//    return menuDao.getMenus();
//    
//    
//}

        
        }

   



