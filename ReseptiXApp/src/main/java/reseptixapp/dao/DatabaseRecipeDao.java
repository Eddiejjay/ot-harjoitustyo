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
                recipes.add(new Recipe(id, name, instruction));    
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
            System.out.println("soi");
          
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
    } 
}
      