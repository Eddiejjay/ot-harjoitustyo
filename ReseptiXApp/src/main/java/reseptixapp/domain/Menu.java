/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.domain;

import java.util.HashMap;
import java.util.Map;

/**
 
 * @author mazeero
 */
public class Menu {
    private String name;
    private Recipe mon;
    private Recipe tue;
    private Recipe wed;
    private Recipe thu;
    private Recipe fri;
    private Recipe sat;
    private Recipe sun;

   
    public Menu(String name, Recipe mon, Recipe tue, Recipe wed, Recipe thu, Recipe fri, Recipe sat, Recipe sun) {
        this.name = name;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    
    
    
    }
    
    
     public String getName() {
        return this.name;
    }
        @Override
public String toString() {
        return this.getName();
    }

public Recipe getMondayRecipe(){
    return this.mon;
    
}
public Recipe getTuesdayRecipe(){
    return this.tue;
}
public Recipe getWednesdayRecipe(){
    return this.wed;

}
public Recipe getThursdayRecipe(){
    return this.thu;

}
public Recipe getFridayRecipe(){
    return this.fri;

}
public Recipe getSaturdayRecipe(){
    return this.sat;

}
public Recipe getSundayRecipe(){
    return this.sun;

}
}