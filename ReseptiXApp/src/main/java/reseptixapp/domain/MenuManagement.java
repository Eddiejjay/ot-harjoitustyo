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

/**
 
 * Menujen toimintoja käsittelevä luokka ui:n ja tietokannan välillä 
 */
public class MenuManagement {
    private DatabaseMenuDao database;
      
    public MenuManagement(DatabaseMenuDao database) {
        this.database = database;
         
           
    }
    
    /**
    * Uuden menun luominen
    *
    * @param name luotavan menun nimi
    * @param recipes  luotavan menun reseptit  
    * 
    * @return menu palauttaa luodun menun
    */
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

  
    /**
    *Kaikkien menujen hakeminen
    * 
    * @return kaikki menut
    */
    public HashMap<String, Menu> getAllMenus() {
        return database.getAllMenus();
    
    
    }
     /**
    *Menun hakeminen id:n mukaan
    * 
    * @return menu
    */
//    public Menu getMenubyId(Integer menuId) {
//        return database.getMenuById(menuId);
//
//    
//    } 
}
