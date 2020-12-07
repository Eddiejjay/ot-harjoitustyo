# Arkkitehtuurikuvaus

## Rakenne 

Ohjelmassa on kolmitasoinen kerrosarkkitehtuuri. Ohjelmassa on seuraavanlainan pakkausrakenne.

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/pakkausarkkitehtuuri.jpg">




Pakkaus reseptixapp.ui sisältää Java FMXL: llä toteutetun graafisen käyttöliittymän, reseptixapp.domain sisältää sovelluslogiikan sekä reseptixapp.dao tietojen tallennuksen tietokantaan. 

## Sovelluslogiikka 

Sovellukseen voi tallentaa reseptejä ja resepteistä koostuvia menuja. Sovelluslogiikka sisältää käsite luokat Recipe ja Menu. Menu sisältää useita reseptejä.

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/recipeAndMenu.jpg">


RecipeManagement ja MenuManagement luokat tarjoavat toiminnallisuudet reseptien ja menujen luomiseen, tallentamiseen ja hakemiseen. 

RecipeManagement luokka tarjoaa seuraavat metodit
- createRecipe(String name, String instruction)
- getRandom()
- getAll() 

MenuManagemetn luokka tarjoaa seuraavat metodit
- createMenu(String name, Recipe mon, Recipe tue, Recipe wed, Recipe thu, Recipe fri, Recipe sat, Recipe sun)
- getAllMenus() 
- getMenuByName(name)

Management luokat pääsevät käsiksi tietokantaan luokkien DatabaseRecipeDao ja DatabaseMenuDao kautta. 



TÄHÄN KUVA LUOKKA/PAKKAUSKAAVIO


<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/AddRecipeSekvenssikaavio.png">
