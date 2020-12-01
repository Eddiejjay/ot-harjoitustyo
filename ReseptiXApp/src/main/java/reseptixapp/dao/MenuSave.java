/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reseptixapp.domain.Menu;

/**    
 *
 * @author mazeero
 */
public class MenuSave {
    private Map<String, Menu> menus; 
    
    
    
    public MenuSave() {
        menus = new HashMap<>();
    }
   
  
    
    public Menu createMenu(String name, Menu menu) {
        this.menus.put(name, menu);
        return menu;
     
       
    }
    public Map<String, Menu> getMenus() {
        return menus;
    }
}
