/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author mazeero
 */
public class Recipe {
    private int id; 
   // private ArrayList<String> ingredients;
    private String name;
    private String instruction;
    
    public Recipe(int id, String name, String instruction){
        this.id = id;
        //this.ingredients = ingredients;
        this.instruction = instruction;
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    

    
    public int getId(){
        return this.id;
    }
//    public void setIngredients(ArrayList ingredients){
//        this.ingredients=ingredients;
//    }
//    public void addIngredient(String ingredient){
//        this.ingredients.add(ingredient);
//        
//    }
//    
//    public ArrayList getIngredients(){
//        return this.ingredients;
//    }
    
    public void setInstruction(String instruction){
        this.instruction = instruction;
        
    }
    
    public String getInstruction(){
        return this.instruction;
       
    }
    
    public void setNimi(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
