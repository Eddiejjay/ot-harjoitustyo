/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.domain;

import java.util.ArrayList;

/**
 *
 * @author mazeero
 */
public class Recipe {
    private int id; 
    private String name;
    private String instruction;
    
    public Recipe(String name, String instruction) {
      
        this.instruction = instruction;
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setInstruction(String instruction) {
        this.instruction = instruction;
        
    }
    
    public String getInstruction() {
        return this.instruction;
       
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    @Override
public String toString() {
    return this.getName();
}
}
