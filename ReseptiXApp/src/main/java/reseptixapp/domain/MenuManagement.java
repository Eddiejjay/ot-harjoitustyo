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
import reseptixapp.dao.DatabaseMenuDao;


/**
 *
 * @author mazeero
 */
public class MenuManagement {
    private DatabaseMenuDao database;
      
    public MenuManagement(DatabaseMenuDao database) {
        this.database = database;
         
           
    }
    
    
    public Menu createMenu(String name, List<Recipe> recipes) {
        Menu menu = new Menu(name, recipes);
        List<Integer> menuRecipeIds = new ArrayList<>();
        
        for (Recipe recipe : recipes) {
            menuRecipeIds.add(recipe.getId());
        }
        
        
        database.addMenuToDatabase(menu.getName(),menuRecipeIds);
        System.out.println("Menumanagement create menu");
        return menu;
     
       
        
    }

  
    public HashMap<String, Menu> getAllMenus() {
        return database.getAllMenus();
    
    
    }
    public Menu getMenubyId(Integer menuId) {
        return database.getMenuById(menuId);

    
    } 
}
