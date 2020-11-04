/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mazeero
 */
public class KassapaateTest {
    Kassapaate kassapaate;
    Maksukortti kortti;
 
    
    @Before
    public void setUp() {
       kassapaate = new Kassapaate();
       
    }
    
    
@Test
public void KassaPaatteenRahamaaraJaMyydytLounaatOikein(){
    assertEquals(100000, kassapaate.kassassaRahaa());
    assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
    assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
    
    
}
 @Test  
 public void KateisostoEdullinenLounasJosMaksuOnRiittavaKassassaOlevaRahamaaraKasvaaLounaanHinnallaJaVaihtorahanSuuruusOikea(){
     kassapaate.syoEdullisesti(500);
     
     assertEquals(100240, kassapaate.kassassaRahaa());
     assertEquals(260 ,kassapaate.syoEdullisesti(500));
     
 }
 @Test  
 public void KateisostoEdullinenLounasJosMaksuOnRiittavaMyytyjenLounaideMaaraKasvaa(){
  kassapaate.syoEdullisesti(240);
   assertEquals(100240, kassapaate.kassassaRahaa());
   assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
   
 
}
 @Test  
 public void KateisostoEdullinenLounasJosMaksuEiRiittavaKassassaOlevaRahaMaaraEiMuutuEikaMyytyjenLounaidenMaaraMuutuSekaKaikkiaRahatPalautetaanVaihtorahana(){
    
 kassapaate.syoEdullisesti(230);
 assertEquals(100000, kassapaate.kassassaRahaa());
 assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
 assertEquals(230, kassapaate.syoEdullisesti(230));
 
}
 @Test  
 public void KateisostoMaukasLounasJosMaksuOnRiittavaKassassaOlevaRahamaaraKasvaaLounaanHinnallaJaVaihtorahanSuuruusOikea(){
     kassapaate.syoMaukkaasti(500);
     
     assertEquals(100400, kassapaate.kassassaRahaa());
     assertEquals(100 ,kassapaate.syoMaukkaasti(500));
     
 }
 @Test  
 public void KateisostoMaukasLounasJosMaksuOnRiittavaMyytyjenLounaideMaaraKasvaa(){
  kassapaate.syoMaukkaasti(400);
   assertEquals(100400, kassapaate.kassassaRahaa());
   assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
   
 
}
 @Test  
 public void KateisostoMaukasLounasJosMaksuEiRiittavaKassassaOlevaRahaMaaraEiMuutuEikaMyytyjenLounaidenMaaraMuutuSekaKaikkiaRahatPalautetaanVaihtorahana(){
    
 kassapaate.syoMaukkaasti(390);
 assertEquals(100000, kassapaate.kassassaRahaa());
 assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
 assertEquals(390, kassapaate.syoMaukkaasti(390));
 
}

// Maksukortin testit alkavat
 //Edullinen lounas
@Test 

public void KorttiOstoEdullinenLounasJosKortillaTarpeeksiRahaaVeloitetaanSummaKortiltaJaPalautetaanTrue(){
    kortti = new Maksukortti(1000);
    kassapaate.syoEdullisesti(kortti);
    
    assertEquals(760, kortti.saldo());
    assertEquals(true, kassapaate.syoEdullisesti(kortti));
}

@Test 
public void KorttiOstoEdullinenLounasJosKortillaTarpeeksiRahaaMyytyjenLounaidenMaaraKasvaa(){
      kortti = new Maksukortti(1000);
    
    assertEquals(true ,kassapaate.syoEdullisesti(kortti));
    assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    
}
    
@Test
public void KorttiOstoEdullinenLounasJosKortillaEiTarpeeksiRahaaKortinRahamaaraEiMuutuJaMyytyjenLounaidenMaaraMuuttumatonSekaPalautetaanFalse(){
      kortti = new Maksukortti(200);
      kassapaate.syoEdullisesti(kortti);
      assertEquals(false, kassapaate.syoEdullisesti(kortti));
      assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
      assertEquals(200,kortti.saldo());
   
}

@Test 
public void KorrtiOstoEdullinenLounasKassassaOlevaRahamaaraEiMuutuKortillaOstettaessa(){
    kortti = new Maksukortti(400);
    
    kassapaate.syoEdullisesti(kortti);
    assertEquals(100000, kassapaate.kassassaRahaa());
    
    
}

//MaukasLounas
@Test 

public void KorttiOstoMaukasLounasJosKortillaTarpeeksiRahaaVeloitetaanSummaKortiltaJaPalautetaanTrue(){
    kortti = new Maksukortti(1000);
    kassapaate.syoMaukkaasti(kortti);
    
    assertEquals(600, kortti.saldo());
    assertEquals(true, kassapaate.syoMaukkaasti(kortti));
}

@Test 
public void KorttiOstoMaukasLounasJosKortillaTarpeeksiRahaaMyytyjenLounaidenMaaraKasvaa(){
      kortti = new Maksukortti(1000);
    
    assertEquals(true ,kassapaate.syoMaukkaasti(kortti));
    assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    
}
    
@Test
public void KorttiOstoMaukasLounasJosKortillaEiTarpeeksiRahaaKortinRahamaaraEiMuutuJaMyytyjenLounaidenMaaraMuuttumatonSekaPalautetaanFalse(){
      kortti = new Maksukortti(200);
      kassapaate.syoMaukkaasti(kortti);
      assertEquals(false, kassapaate.syoMaukkaasti(kortti));
      assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
      assertEquals(200,kortti.saldo());
   
}

@Test 
public void KorrtiOstoMaukasLounasKassassaOlevaRahamaaraEiMuutuKortillaOstettaessa(){
    kortti = new Maksukortti(600);
    
    kassapaate.syoMaukkaasti(kortti);
    assertEquals(100000, kassapaate.kassassaRahaa());




}


@Test
public void KortilleRahaaLadattaessaKortinSaldoMuuttuuJaKassassaOlevaRahaMaaraKasvaaLadatullaSummalla(){
    kortti = new Maksukortti(200);
    kassapaate.lataaRahaaKortille(kortti,300);
    
    assertEquals(500, kortti.saldo());
    assertEquals(100300, kassapaate.kassassaRahaa());
    
    
} 
//Jaccon mukaan nämä testit tulee lisätä jotta kattavuus 100&


@Test 
public void KortilleRahaaLadattaessaNegativinenArvoKortinSaldoPysyyEnnallaanJaKassassaOlevaRahamaaraPysyyEnnallaan(){
    kortti = new Maksukortti(159640000);
    
    kassapaate.lataaRahaaKortille(kortti, -10);
    assertEquals(159640000, kortti.saldo());
    assertEquals(100000, kassapaate.kassassaRahaa());
    
    
}



}



