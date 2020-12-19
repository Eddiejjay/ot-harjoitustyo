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
        try {
            PreparedStatement  ps = con.prepareStatement("INSERT INTO menu(menuname) VALUES(?)");
            ps.setString(1, name);
            ps.execute();
            PreparedStatement ps2 = con.prepareStatement("SELECT id FROM Menu WHERE id=(SELECT max(id) FROM Menu)");
            ResultSet rs = ps2.executeQuery();    
            int  menuId = rs.getInt("id") + 1;       
            for (int i = 0; i < menuRecipeIds.size(); i++) {
                PreparedStatement ps3 = con.prepareStatement("INSERT INTO MenusRecipes (recipe_id, menu_id) VALUES (?,?)");
                ps3.setInt(1, menuRecipeIds.get(i));
                ps3.setInt(2, menuId);
                ps3.execute();          
            }  
        } catch (SQLException e) { 
            System.out.println(e.toString());
        }  
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
            PreparedStatement ps = con.prepareStatement("SELECT id from Menu");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuIds.add(rs.getInt("id"));    
            }
            for (Integer id : menuIds) {    
                PreparedStatement ps2 = con.prepareStatement(" SELECT * FROM Menu, Recipe, MenusRecipes WHERE Menu.id = menu_id AND Recipe.id = recipe_id and menu.id = ?;");
                ps2.setInt(1, id);
                ResultSet rs2 = ps2.executeQuery();
                String menuName = "";
                List<Recipe> menusRecipes = new ArrayList<>();
                while (rs2.next()) {
                    menuName = rs2.getString("menuName");
                    Integer recipeId = rs2.getInt("recipe_id");
                    String recipeName = rs2.getString("recipeName");
                    String instruction = rs2.getString("instruction");
                    menusRecipes.add(new Recipe(recipeId, recipeName, instruction));              
                }
                menus.put(menuName, new Menu(id, menuName, menusRecipes));    
            }
            return menus;
        
        } catch (SQLException e) {            
            System.out.println(e.toString());
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
            
            String sql2 = "DELETE FROM menusRecipes";
            ps = con.prepareStatement(sql2);
            ps.execute();
          
          
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
 
    }
}