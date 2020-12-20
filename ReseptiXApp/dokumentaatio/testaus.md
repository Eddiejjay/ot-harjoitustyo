# Testausdokumentti 

Sovellusta on testattu integraatio- ja yksikkötesteillä. Junitin avulla.
Järjestelmätason testaus on suoritettu manuaalisesti. 
 
## Yksikkö- ja integraatiotestaus

Testaus perustuu pääosin sovelluslogiikan ja tietokantaa käsittelevien luokkien yhteistoimintaa testaaviin testeihin.
Pakkauksessa reseptixapp.domain
sijaitsevat luokat RecipeManagement sekä Menumanagement sisältävät metodeja, mitkä
kutsuvat pakkauksen reseptixapp.dao luokkien  databaseRecipeDao sekä databaseMenudao metodeja. 

Integraatiotestit käyttävät testausta varten luotua tietokantaa testi.db. 

## Testauskattavuus 
Testauksen rivikattavuus on 76% ja haarautumakattavuus 91%. Käyttöliittymää ei ole otettu testaukseen mukaan. 

<img src=https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/jacoco.png/>

## Järjestelmätestaus

Järjestelmä testaus on suoritettu manuaalisesti.

Sovellusta on testattu yliopiston etätyöpöydällä Linux Cubbli käyttöjärjestelmällä. 

## Toiminnallisuus 
Sovelluksen toimintaa on testattu että se toimii kun ohjelmaan syötetään kaikki tarvittavat tiedot. 


## Sovelluksen laatuongelmat 
Virheellisiä syötteitä ei ole käsitelty. 
Sovellus näyttää vasta toisen lisätyn menun, vaikka se tallentuukin tietokantaan. 


