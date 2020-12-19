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
/**
 * Reseptien tietokantatoiminnallisuuden toteuttava luokka 
 */


public class DatabaseRecipeDao { 
    private Connection con;
   
    public DatabaseRecipeDao(Connection con) {
        this.con = con;       
    }
    /**
    * Reseptin lisääminen tietokantaan
    *
    * @param recipe tietokantaan lisättävä resepti
    */
    public void addRecipeToDatabase(Recipe recipe) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO recipe(recipename, instruction) VALUES(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, recipe.getName());
            ps.setString(2, recipe.getInstruction());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }    
    }
  
    /**
    * Reseptin  hakeminen id:n mukaan tietokannasta
    *
    * @param id haettavan reseptin id   
    * 
    * @return palauttaa reseptin
    */
    public Recipe getRecipeById(Integer id){
        PreparedStatement ps = null;
        ResultSet rs = null;  
        try {
            String sql = "SELECT * FROM recipe where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(id));
            rs = ps.executeQuery();
            String name = rs.getString("recipename");
            String instruction = rs.getString("instruction");
            
        return new Recipe(name, instruction);
   
        } catch (SQLException e) {
            System.out.println( e);
        }
        return new Recipe("recipename", "instruction");      
    }
    
        /**
    * Reseptin  hakeminen nimen mukaan tietokannasta
    *
    * @param name1 haettavan reseptin nimi  
    * 
    * @return palauttaa reseptin
    */
   
    public Recipe getRecipeByName(String name1) {
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {
            String sql = "SELECT * FROM recipe where recipename = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name1);
            rs = ps.executeQuery();
            
            String name = rs.getString("name");
            String instruction = rs.getString("instruction");
            return new Recipe(name, instruction);
   
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return new Recipe("recipename", "instruction"); 
          

    }
    /**
    * Kaikkien reseptien hakeminen tietokannasta
    * 
    * @return palauttaa kaikki reseptit
    */
    public List<Recipe> getAllRecipes() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Recipe> recipes = new ArrayList<>();
    
        try {
            String sql = "SELECT * FROM Recipe";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("recipename");
                String instruction = rs.getString("instruction");
                recipes.add(new Recipe(id,name, instruction));    
            }
            return recipes;
     
        } catch (SQLException e) {
            System.out.println(e.toString());
        } 
        return recipes;
    }
    
    /**
    * Kaikkien reseptien poistaminen tietokannasta
    */
    
    public void deleteRecipesFromDatabase() {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Recipe";
            ps = con.prepareStatement(sql);
            ps.execute();
          
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
    } 
}
      