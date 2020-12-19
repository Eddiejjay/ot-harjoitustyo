package reseptixapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reseptixapp.domain.Menu;
import reseptixapp.domain.Recipe;

/**
 *
 * @author mazeero
 */
/**
 
 * Menujen tietokantatoiminnallisuuden toteuttava luokka 
 */


public class DatabaseMenuDao { 
    private Connection con;
     
public DatabaseMenuDao(Connection con) {
    this.con = con;
 }

    /**
    * Lisää menun tietokantaan
    *
    * @param name luotavan menun nimi
    * @param menuRecipeIds  luotavan menun reseptien id:t
    */
    
    public void addMenuToDatabase(String name, List<Integer> menuRecipeIds) {
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs = null;
        try {
            
            String sql = "INSERT INTO menu(menuname) VALUES(?)";
            String sql2 = "SELECT id FROM Menu WHERE id=(SELECT max(id) FROM Menu)"; 
            String sql3 = "INSERT INTO MenusRecipes (recipe_id, menu_id) VALUES (?,?)";
     
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
   
            ps2 = con.prepareStatement(sql2);
            rs = ps2.executeQuery();
            int  menuId = rs.getInt("id")+1;
            
            for (int i = 0; i < menuRecipeIds.size() ; i++) {
                ps3 = con.prepareStatement(sql3);
                ps3.setInt(1,menuRecipeIds.get(i));
                ps3.setInt(2,menuId);
                ps3.execute();
                     
             }
           
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        
    }
    
/**
    * Menun hakeminen tietokannasta id:n perusteella
    *
    * @param id haettavan menun id
    * @return menu
    */
    
    public Menu getMenuById(Integer id) {
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = 
                         "SELECT *\n" +
                         "FROM Menu, Recipe, MenusRecipes \n" +
                         "WHERE Menu.id = menu_id AND Recipe.id = recipe_id and menu.id = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(id));
            rs = ps.executeQuery();
 

            String menuName = rs.getString("name");
            List<Recipe> menusRecipes = new ArrayList<>();
            String recipeId = "";
            String recipeName = "";
            String instruction = "";

            while (rs.next()) {
                recipeId = rs.getString("recipe.id");
                recipeName = rs.getString("recipe.name");
                instruction = rs.getString("recipe.instruction");
                menusRecipes.add(new Recipe(Integer.parseInt(recipeId), recipeName, instruction));
            }
         
        
            return new Menu(menuName, menusRecipes);
  
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
     return null;
      

    }
    
    /**
    * Kaikkien menujen hakeminen tietokannasta
    * 
    * @return Kaikki menut
    */
    
     public HashMap<String, Menu> getAllMenus() {

        HashMap<String, Menu> menus = new HashMap<>();
        ArrayList<Integer> menuIds = new ArrayList<>();

  
        try {
            String sql = "SELECT id from Menu";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               menuIds.add(rs.getInt("id"));    
            }
       
            String sql2 = " SELECT * FROM Menu, Recipe, MenusRecipes WHERE Menu.id = menu_id AND Recipe.id = recipe_id and menu.id = ?;";
          
            for (Integer id : menuIds){    
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, id);
                ResultSet rs2= ps2.executeQuery();
                String menuName = "";
                List<Recipe> menusRecipes = new ArrayList<>();
                     while (rs2.next()) {
                        menuName = rs2.getString("menuName");
                        Integer recipeId = rs2.getInt("recipe_id");
                        String recipeName = rs2.getString("recipeName");
                        String instruction = rs2.getString("instruction");
                        menusRecipes.add(new Recipe(recipeId, recipeName, instruction));              
            }
                menus.put(menuName, new Menu(id,menuName ,menusRecipes)); 
                 
        }
        return menus;
        
            }catch (SQLException e) {            
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return menus;
     }
            
     /**
    * Kaikkien menujen poistaminen tietokannasta
    *
   
    */
     
    public void deleteMenusFromDatabase() {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM menu";
            ps = con.prepareStatement(sql);
            ps.execute();
          
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
 
    }
}