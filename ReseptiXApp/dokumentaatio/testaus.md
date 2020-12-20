#Testausdokumentti 

Sovellusta on testattu integraatio- ja yksikkötesteillä. Junitin avulla.
Järjestelmätason testaus on suoritettu manuaalisesti. 
 
## Yksikkö- ja integraatiotestaus

Testaus perustuu pääosin sovelluslogiikan ja tietokantaa käsittelevien luokkien yhteistoimintaa testaaviin testeihin.
Pakkauksessa reseptixapp.domain
sijaitsevat luokat RecipeManagement sekä Menumanagement sisältävät metodeja, mitkä
kutsuvat pakkauksen reseptixapp.dao luokkien  databaseRecipeDao sekä databaseMenudao metodeja. 

Integraatiotestit käyttävät testausta varten luotua tietokantaa testi.db. 



