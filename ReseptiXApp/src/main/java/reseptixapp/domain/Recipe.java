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

/**
 *Yksittäistä reseptiä kuvaava luokka
 */
public class Recipe {
    private Integer id;
    private String name;
    private String instruction;
    
    public Recipe(String name, String instruction) {
      
        this.instruction = instruction;
        this.name = name;
    }
    
     public Recipe(int id, String name, String instruction) {
        this.id = id;
        this.instruction = instruction;
        this.name = name;
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
    public Integer getId(){
        return id;
    }
    public void  setId(Integer id){
        this.id=id;
    }


    @Override
public String toString() {
        return this.getName();
    }
}
