/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.domain;

import java.util.HashMap;
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
    
    
    public Menu createMenu(String name, Recipe mon, Recipe tue, Recipe wed, Recipe thu, Recipe fri, Recipe sat, Recipe sun) {
        Menu menu = new Menu(name, mon, tue, wed, thu, fri, sat, sun);
      
        String mondayId = menu.getMondayRecipe().getName();
        String tuesdayId = menu.getTuesdayRecipe().getName();
        String wednesdayId = menu.getWednesdayRecipe().getName();
        String thursdayId = menu.getThursdayRecipe().getName();
        String fridayId = menu.getFridayRecipe().getName();
        String saturdayId = menu.getSaturdayRecipe().getName();
        String sundayId = menu.getSundayRecipe().getName();
        
        
        database.addMenuToDatabase(menu.getName(), mondayId, tuesdayId, wednesdayId, thursdayId, fridayId, saturdayId, sundayId);
        return menu;
     
       
        
    }

  
    public HashMap<String, Menu> getAllMenus() {
        return database.getAllMenus();
    
    
    }
    public Menu getMenubyName(String name) {
        return database.getMenuByName(name);

    
    } 
}
