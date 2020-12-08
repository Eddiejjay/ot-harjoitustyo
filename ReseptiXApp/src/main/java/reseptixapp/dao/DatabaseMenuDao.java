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
    private String databaseName;
      
    public DatabaseMenuDao(String databaseName) {
        this.databaseName = databaseName;
    
    }
    public Connection connect() {
        Connection con = null;
        try { 
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + databaseName + "");
//            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
      
        return con;
    }
    
    
    
    public void addMenuToDatabase(String name, String mondayId, String tuesdayId, String wednesdayId, String thursdayId, String fridayId, String saturdayId, String sundayId) {
        Connection con2 = connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO menu(name, mondayRecipeId,tuesdayRecipeId,wednesdayRecipeId,thursdayRecipeId,fridayRecipeId,saturdayRecipeId,sundayRecipeId) VALUES(?,?,?,?,?,?,?,?)";
            ps = con2.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, mondayId);
            ps.setString(3, tuesdayId);
            ps.setString(4, wednesdayId);
            ps.setString(5, thursdayId);
            ps.setString(6, fridayId);
            ps.setString(7, saturdayId);
            ps.setString(8, sundayId);
            
            ps.execute();
            System.out.println("Menu added to database!");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        
    }
    

    
    public Menu getMenuByName(String name1) {
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM menu where name = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, name1);
            rs = ps.executeQuery();
 
//    System.out.println("RecipeByName \n");
 
            String name = rs.getString("name");
            String mondayRecipeId = rs.getString("mondayRecipeId");
            String tuesdayRecipeId = rs.getString("tuesdayRecipeId");
            String wednesdayRecipeId = rs.getString("wednesdayRecipeId");
            String thursdayRecipeId = rs.getString("thursdayRecipeId");
            String fridayRecipeId = rs.getString("fridayRecipeId");
            String saturdayRecipeId = rs.getString("saturdayRecipeId");
            String sundayRecipeId = rs.getString("sundayRecipeId");
         
 
    


            String sql1 = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, mondayRecipeId);
            rs = ps.executeQuery();
            String mondayName = rs.getString("name");
            String mondayInstruction = rs.getString("instruction");
            Recipe mondayRecipe = new Recipe(mondayName, mondayInstruction);

            String sql2 = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql2);
            ps.setString(1, tuesdayRecipeId);
            rs = ps.executeQuery();
            String tuesdayName = rs.getString("name");
            String tuesdayInstruction = rs.getString("instruction");
            Recipe tuesdayRecipe = new Recipe(tuesdayName, tuesdayInstruction);
        

            String sql3 = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql3);
            ps.setString(1, wednesdayRecipeId);
            rs = ps.executeQuery();
            String wednesdayName = rs.getString("name");
            String wednesdayInstruction = rs.getString("instruction");
            Recipe wednesdayRecipe = new Recipe(wednesdayName, wednesdayInstruction);

            String sql4 = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql4);
            ps.setString(1, thursdayRecipeId);
            rs = ps.executeQuery();
            String thursdayName = rs.getString("name");
            String thursdayInstruction = rs.getString("instruction");
            Recipe thursdayRecipe = new Recipe(thursdayName, thursdayInstruction);

        
        
            String sql5 = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql5);
            ps.setString(1, fridayRecipeId);
            rs = ps.executeQuery();
            String fridayName = rs.getString("name");
            String fridayInstruction = rs.getString("instruction");
            Recipe fridayRecipe = new Recipe(fridayName, fridayInstruction);



            String sql6 = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql6);
            ps.setString(1, saturdayRecipeId);
            rs = ps.executeQuery(); 
            String saturdayName = rs.getString("name");
            String saturdayInstruction = rs.getString("instruction");
            Recipe saturdayRecipe = new Recipe(saturdayName, saturdayInstruction);


            String sql7 = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql7);
            ps.setString(1, sundayRecipeId);
            rs = ps.executeQuery();
            String sundayName = rs.getString("name");
            String sundayInstruction = rs.getString("instruction");
            Recipe sundayRecipe = new Recipe(sundayName, sundayInstruction);


        
            return new Menu(name, mondayRecipe, tuesdayRecipe, wednesdayRecipe, thursdayRecipe, fridayRecipe, saturdayRecipe, sundayRecipe);
  
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally { 
            
            try { 
                rs.close();
                ps.close();
                con.close();
            }
            catch (SQLException e) {
                System.out.println(e.toString());
        
            }
        
        }
        
        return new Menu("name", new Recipe("ss", "ll"), new Recipe("ss", "ll"), new Recipe("ss", "ll"), new Recipe("ss", "ll"), new Recipe("ss", "ll"), new Recipe("ss", "ll"), new Recipe("ss", "ll"));
      

    }
    public HashMap<String, Menu> getAllMenus() {
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        HashMap<String, Menu> menus = new HashMap<>();
    
        try {
            String sql = "SELECT * FROM menu";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
     
//    System.out.println("All Menus \n");
   
            while (rs.next()) {
         
                String name = rs.getString("name");
                String mondayRecipeId = rs.getString("mondayRecipeId");
                String tuesdayRecipeId = rs.getString("tuesdayRecipeId");
                String wednesdayRecipeId = rs.getString("wednesdayRecipeId");
                String thursdayRecipeId = rs.getString("thursdayRecipeId");
                String fridayRecipeId = rs.getString("fridayRecipeId");
                String saturdayRecipeId = rs.getString("saturdayRecipeId");
                String sundayRecipeId = rs.getString("sundayRecipeId");

//    System.out.println("Name: "+ name);
   
                String sql1 = "SELECT * FROM recipe where name = ?";
                ps = con.prepareStatement(sql1);
                ps.setString(1, mondayRecipeId);
                rs2 = ps.executeQuery();
                String mondayName = rs2.getString("name");
                String mondayInstruction = rs2.getString("instruction");
                Recipe mondayRecipe = new Recipe(mondayName, mondayInstruction);

                String sql2 = "SELECT * FROM recipe where name = ?";
                ps = con.prepareStatement(sql2);
                ps.setString(1, tuesdayRecipeId);
                rs2 = ps.executeQuery();
                String tuesdayName = rs2.getString("name");
                String tuesdayInstruction = rs2.getString("instruction");
                Recipe tuesdayRecipe = new Recipe(tuesdayName, tuesdayInstruction);


                String sql3 = "SELECT * FROM recipe where name = ?";
                ps = con.prepareStatement(sql3);
                ps.setString(1, wednesdayRecipeId);
                rs2 = ps.executeQuery();
                String wednesdayName = rs2.getString("name");
                String wednesdayInstruction = rs2.getString("instruction");
                Recipe wednesdayRecipe = new Recipe(wednesdayName, wednesdayInstruction);

                String sql4 = "SELECT * FROM recipe where name = ?";
                ps = con.prepareStatement(sql4);
                ps.setString(1, thursdayRecipeId);
                rs2 = ps.executeQuery();
                String thursdayName = rs2.getString("name");
                String thursdayInstruction = rs2.getString("instruction");
                Recipe thursdayRecipe = new Recipe(thursdayName, thursdayInstruction);



                String sql5 = "SELECT * FROM recipe where name = ?";
                ps = con.prepareStatement(sql5);
                ps.setString(1, fridayRecipeId);
                rs2 = ps.executeQuery();
                String fridayName = rs2.getString("name");
                String fridayInstruction = rs2.getString("instruction");
                Recipe fridayRecipe = new Recipe(fridayName, fridayInstruction);



                String sql6 = "SELECT * FROM recipe where name = ?";
                ps = con.prepareStatement(sql6);
                ps.setString(1, saturdayRecipeId);
                rs2 = ps.executeQuery(); 
                String saturdayName = rs2.getString("name");
                String saturdayInstruction = rs2.getString("instruction");
                Recipe saturdayRecipe = new Recipe(saturdayName, saturdayInstruction);


                String sql7 = "SELECT * FROM recipe where name = ?";
                ps = con.prepareStatement(sql7);
                ps.setString(1, sundayRecipeId);
                rs2 = ps.executeQuery();
                String sundayName = rs2.getString("name");
                String sundayInstruction = rs2.getString("instruction");
                Recipe sundayRecipe = new Recipe(sundayName, sundayInstruction);

                Menu menu = new Menu(name, mondayRecipe, tuesdayRecipe, wednesdayRecipe, thursdayRecipe, fridayRecipe, saturdayRecipe, sundayRecipe);

                menus.put(name, menu);
              
            }
            return menus;
     
        } catch (SQLException e) {
            System.out.println(e.toString());
//    } finally { 
//        try { 
//            rs.close();
//           ps.close();
//            con.close();
//                return menus; // ??
//        }
 
//        catch (SQLException e){
//        System.out.println(e.toString());

            return menus; // ??
        }
 
    }
    public void deleteMenusFromDatabase() {
        Connection con2 = connect();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM menu";
            ps = con2.prepareStatement(sql);
            ps.execute();
          
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Perse");
        }
 
 
 
 
 
 
 
    }
}