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
public class DatabaseMenuDao { 
    private Connection con;
     
        public DatabaseMenuDao(Connection con) {
            this.con = con;
        }

    
    
    public void addMenuToDatabase(String name, List<Integer> menuRecipeIds) {
        System.out.println("Add menutodatabase ");
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs = null;
        try {
            
            String sql = "INSERT INTO menu(menuname) VALUES(?)";
            String sql2 = "SELECT id FROM Menu WHERE id=(SELECT max(id) FROM Menu)"; 
            String sql3 = "INSERT INTO MenusRecipes (recipe_id, menu_id) VALUES (?,?)";
         
       
     
            // 1. sql koment 
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
            System.out.println("Perseenreikäå");
            
            
            // 2. sql komento 
           
            ps2 = con.prepareStatement(sql2);
            System.out.println("ps2 prepare ");
            rs = ps2.executeQuery();
            int  menuId = rs.getInt("id")+1;
            
               // 3. sql komento 
           
             for (int i = 0; i < menuRecipeIds.size() ; i++) {
             ps3 = con.prepareStatement(sql3);
             ps3.setInt(1,menuRecipeIds.get(i));
             ps3.setInt(2,menuId);
             ps3.execute();
                     
             }
           
            System.out.println("Menu added to database!");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        
    }
    

    
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
//        } finally { 
//            
//            try { 
//                //rs.close();
//                //ps.close();
//              //  con.close();
//            }
//            catch (SQLException e) {
//                System.out.println(e.toString());
//        
//            }
//        
        }
        
     return null;
      

    }
    
     public HashMap<String, Menu> getAllMenus() {

        HashMap<String, Menu> menus = new HashMap<>();
        ArrayList<Integer> menuIds = new ArrayList<>();

  
        try {
           // sql 1 menu count 
//            String sql = "SELECT id FROM Menu WHERE id=(SELECT max(id) FROM Menu)";
            String sql = "SELECT id from Menu";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //int  menuCount = rs.getInt("id");
            while (rs.next()){
               menuIds.add(rs.getInt("id"));
                
            }
          
            
            // sql2 
            
            String sql2 = " SELECT * FROM Menu, Recipe, MenusRecipes WHERE Menu.id = menu_id AND Recipe.id = recipe_id and menu.id = ?;";
            rs.close();
            for (Integer id : menuIds){
               
            //            for (int i = 1; i <= menuCount;i++){
                //Errorit tulee kun for looppi lähtee toista kertaa käyntiin 
           //         rs2=con.createStatement().executeQuery(" SELECT * FROM Menu, Recipe, MenusRecipes WHERE Menu.id = menu_id AND Recipe.id = recipe_id and menu.id = ?;"); 
                System.out.println(menuIds);
                
                
                
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, id);
                ResultSet rs2= ps2.executeQuery();
                
                
                String menuName = "";
                List<Recipe> menusRecipes = new ArrayList<>();
                  //Haetaan kaikki reseptit menuun 
                  
                     while (rs2.next()) {
                          menuName = rs2.getString("menuName");
                         Integer recipeId = rs2.getInt("recipe_id");
                        String recipeName = rs2.getString("recipeName");
                        String instruction = rs2.getString("instruction");
                        menusRecipes.add(new Recipe(recipeId, recipeName, instruction));  
                         System.out.println(menusRecipes);
                         
            }
                      rs2.close();
                 menus.put(menuName, new Menu(id,menuName ,menusRecipes)); 
                 
                System.out.println(menus);
        }
        return menus;
        
                }catch (SQLException e) {
                    System.out.println("p");
                    
            System.out.println(e.toString());
             e.printStackTrace();
            System.out.println("p");
        }
        return menus;
     }
            
     
    public void deleteMenusFromDatabase() {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM menu";
            ps = con.prepareStatement(sql);
            ps.execute();
          
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Perse");
        }
 
    }
}