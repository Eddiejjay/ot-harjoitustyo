# Arkkitehtuurikuvaus

## Rakenne 

Ohjelmassa on kolmitasoinen kerrosarkkitehtuuri. Ohjelmassa on seuraavanlainan pakkausrakenne.

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/pakkausarkkitehtuuri.jpg">




Pakkaus reseptixapp.ui sisältää Java FMXL: llä toteutetun graafisen käyttöliittymän, reseptixapp.domain sisältää sovelluslogiikan sekä reseptixapp.dao tietojen tallennuksen tietokantaan. 

## Käyttöliittymä

Käyttöliittymässä 5 erilaista näkymää. 
- etusivu, jossa käyttäjä näkee reseptit ja menut
- lisää resepti
- lisää menu 
- resepti 
- menu


Näkymät on rakennettu java FXML: llä Scenebuilderia käyttäen. Jokainen näkymä on Scene- olio joka sijoitetaan sovelluksen stageen silloin kun sen halutaan olevan esillä. Jokaisella näkymällä on oma FXML tiedosto sekä kontrolleri luokka. Kontrolleri luokka määrittää mitä näkymän elementeissä näytetään ja mitä tapahtuu kun nappeja painetaan. 

Kaikkien näkymien yhteistoimintaa ohjaa luokka FXMLUI. 


ESIMERKKEJÄ NAPPIEN TOIMINNASTA ?


## Sovelluslogiikka 

Sovellukseen voi tallentaa reseptejä ja resepteistä koostuvia menuja. Sovelluslogiikka sisältää käsite luokat Recipe ja Menu. Menu sisältää useita reseptejä.

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/Monestamonen.png">


RecipeManagement ja MenuManagement luokat tarjoavat toiminnallisuudet reseptien ja menujen luomiseen, tallentamiseen ja hakemiseen. 

RecipeManagement luokka tarjoaa seuraavat metodit
- createRecipe(String name, String instruction)
- getRandom()
- getAll() 

MenuManagement luokka tarjoaa seuraavat metodit
- createMenu(String name, List<Recipe> recipes)
- getAllMenus() 

Management luokat pääsevät käsiksi tietokantaan luokkien DatabaseRecipeDao ja DatabaseMenuDao kautta. 

TÄHÄN KUVA LUOKKA/PAKKAUSKAAVIO


<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/AddRecipeSekvenssikaavio.png">


## Tietojen pysyväistallennus 

Pakkauksessa reseptixapp.dao olevat luokat databaseRecipeDao, databaseMenuDao ja databaseConnection pitävät huolen tietojen tallentamisesta tietokantaan

### Tietokannat 

Sovelluksen mukana tulee tietokanta recipesAndMenus.db sekä testi.db. RecipesAndMenus.db toimii käyttäjän reseptien ja menujen tallennuspaikkana. Testi.db tietokantaa käytetään testauksessa. 

Sovelluksessa on helppo muuttaa käytettävää tietokantaa. Käytettävän tietokannan nimi annetaan parametrina FXMLUIluokassa DataBaseConnection luokan konstruktorille. Testausta varten tietokannan voi muuttaa halutessaan testiluokistta. 

Tietokanta sisältää kolme taulua. 
<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/tietokantataulut.png">

Tietokantaan lisätään tietoa ja sieltä haetaan tietoa luokkien databaseRecipeDao sekä databaseMenuDao avulla. 


## Päätoiminnallisuudet 

Reseptin lisääminen 

Menun lisääminen 

Reseptin katsominen 










