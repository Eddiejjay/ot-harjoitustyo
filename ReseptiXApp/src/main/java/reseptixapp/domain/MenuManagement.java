/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.domain;

import java.util.Map;
import reseptixapp.dao.MenuSave;

/**
 *
 * @author mazeero
 */
public class MenuManagement {
    private MenuSave menuDao;
       
    public MenuManagement(MenuSave menuDao) {
        this.menuDao = menuDao;
           
           
    }
    
    
    public Menu createMenu(String name, Recipe mon, Recipe tue, Recipe wed, Recipe thu, Recipe fri, Recipe sat, Recipe sun) {
        Menu menu = new Menu(name, mon, tue, wed, thu, fri, sat, sun);
        return menuDao.createMenu(name, menu);
     
       
        
    }

    public Map<String, Menu> getAllMenus() {
        return menuDao.getMenus();
    
    
    }

    
}
