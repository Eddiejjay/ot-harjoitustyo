package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test 
    public void kortinSaldoAlussaOikein(){
        
         assertEquals("saldo: 10.0", kortti.toString());
       
        
    }
    @Test 
    public void rahanLataaminenKasvattaaSaldoaOikein(){
       kortti.lataaRahaa(1000);
       assertEquals("saldo: 20.0", kortti.toString());
       
       
    }
    @Test
    public void saldoVaheneeOikeinJosRahaatarpeeksi(){
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.0", kortti.toString());
    }
        
        
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi(){
        kortti.otaRahaa(1500);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
   public void otaRahaaMetodiPalauttaaTrueJosRahatRiittivat(){
       assertTrue(kortti.otaRahaa(1000) ==true);
  
     
   
}
   @Test
   public void otaRahaaMetodiPalauttaaFalseJosRahatEivatRiittaneet(){
       assertTrue(kortti.otaRahaa(1500) == false);
   }
   @Test    
   public void saldoMetodiToimiiOikein(){
               
       assertEquals(1000,kortti.saldo());
   }
}