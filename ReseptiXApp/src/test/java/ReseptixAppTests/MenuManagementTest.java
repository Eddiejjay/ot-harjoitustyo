/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReseptixAppTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reseptixapp.dao.MenuSave;
import reseptixapp.dao.RecipeSave;
import reseptixapp.domain.Menu;
import reseptixapp.domain.MenuManagement;
import reseptixapp.domain.Recipe;
import reseptixapp.domain.RecipeManagement;

/**
 *
 * @author mazeero
 */
public class MenuManagementTest {
     private MenuSave menuDao;
       private MenuManagement menuManagement;
    
    public MenuManagementTest() {
    }
    
  
    
 
    @Before
    public void setUp() {
        menuDao = new MenuSave();
        menuManagement = new MenuManagement(menuDao);
    }

@Test

public void createMenuCreatesMenu(){
   Recipe recipe1 = new Recipe("Kaalilaatikko","14kg kaalia");
   Recipe recipe2 = new Recipe("Kaalilaatikko","14kg kaalia");
   Recipe recipe3 = new Recipe("Kaalilaatikko","14kg kaalia");
   Recipe recipe4 = new Recipe("Kaalilaatikko","14kg kaalia");
   Recipe recipe5 = new Recipe("Kaalilaatikko","14kg kaalia");
   Recipe recipe6 = new Recipe("Kaalilaatikko","14kg kaalia");
   Recipe recipe7 = new Recipe("Kaalilaatikko","14kg kaalia");
  
   menuManagement.createMenu("Jorman KaaliMenu", recipe1, recipe2, recipe3, recipe4, recipe5, recipe6, recipe7);
   
   int menusSize = menuManagement.getAllMenus().size();
   assertEquals(1, menusSize);
   
}

}
