# Arkkitehtuurikuvaus

## Rakenne 

Ohjelmassa on kolmitasoinen kerrosarkkitehtuuri. Ohjelmassa on seuraavanlainan pakkausrakenne.

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/pakkausarkkitehtuuri.jpg">




Pakkaus reseptixapp.ui sisältää Java FMXL: llä toteutetun graafisen käyttöliittymän, reseptixapp.domain sisältää sovelluslogiikan sekä reseptixapp.domain tietojen tallennuksen tietokantaan. 

## Sovelluslogiikka 

Sovellukseen voi tallentaa reseptejä ja resepteistä koostuvia menuja. Sovelluslogiikka sisältää käsite luokat Recipe ja Menu. 

RecipeManagement ja MenuManagement luokat tarjoavat toiminnallisuudet reseptien ja menujen luomiseen, tallentamiseen ja hakemiseen. 




<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/luokkaPakkausAlustava.jpg">
<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/AddRecipeSekvenssikaavio.png">
