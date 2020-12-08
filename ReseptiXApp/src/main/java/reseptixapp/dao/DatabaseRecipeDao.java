package reseptixapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reseptixapp.domain.Recipe;

/**
 *
 * @author mazeero
 */
public class DatabaseRecipeDao { 
    private String databaseName;
    
    public DatabaseRecipeDao(String databaseName) {
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
    
    
    
    public void addRecipeToDatabase(String name, String instruction) {
        Connection con2 = connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO recipe(name, instruction) VALUES(?,?)";
            ps = con2.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, instruction);
            ps.execute();
            //System.out.println("Recipe added to database!");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        
    }
    

    
    public Recipe getRecipeByName(String name1) {
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {
            String sql = "SELECT * FROM recipe where name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name1);
            rs = ps.executeQuery();

//    System.out.println("RecipeByName \n");
 
            String name = rs.getString("name");
            String instruction = rs.getString("instruction");
        

//    System.out.println("Name: "+ name);
//    System.out.println("Instruction: " + instruction);
           
            return new Recipe(name, instruction);
   
        } catch (SQLException e) {
////        System.out.println(e.toString());
//    } finally { 
//            
//        try { 
//            rs.close();
//            ps.close();
//            con.close();
//        }
//        catch (SQLException e){
//        System.out.println(e.toString());
//        
//}
        
        }
        
        return new Recipe("name", "instruction"); 
       
    }
    public List<Recipe> getAllRecipes() {
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Recipe> recipes = new ArrayList<>();
    
        try {
            String sql = "SELECT * FROM Recipe";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
     
//    System.out.println("All recipes\n");
            while (rs.next()) {
                String name = rs.getString("name");
                String instruction = rs.getString("instruction");
                recipes.add(new Recipe(name, instruction));

//    System.out.println("Name: "+ name);
//    System.out.println("Instruction: " + instruction);
                
            }
            return recipes;
     
        } catch (SQLException e) {
            System.out.println(e.toString());
//    } finally { 
//        try { 
//            rs.close();
//            ps.close();
//            con.close();
//                return recipes; // ??
//        }
//  
//        catch (SQLException e){
//        System.out.println(e.toString());
//}
//        return recipes; // ??
        } 
        return recipes;
    }
    
    public void deleteRecipesFromDatabase() {
        Connection con2 = connect();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Recipe";
            ps = con2.prepareStatement(sql);
            ps.execute();
          
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Perse");
        }
        
        
    
    
 
 
    } 
}
      