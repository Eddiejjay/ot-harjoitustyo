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


## Sovelluslogiikka 

Sovellukseen voi tallentaa reseptejä ja resepteistä koostuvia menuja. Sovelluslogiikka sisältää käsite luokat Recipe ja Menu. Menu sisältää useita reseptejä ja sama resepti voi olla monessa menussa. 

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/Monestamonen.png">


RecipeManagement ja MenuManagement luokat tarjoavat toiminnallisuudet reseptien ja menujen luomiseen, tallentamiseen ja hakemiseen. 

RecipeManagement luokka tarjoaa seuraavat metodit
- createRecipe(String name, String instruction)
- getRandom()
- getAll() 

MenuManagement luokka tarjoaa seuraavat metodit
- createMenu(String name, List <Recipe> recipes)
- getAllMenus() 

Management luokat pääsevät käsiksi tietokantaan luokkien DatabaseRecipeDao ja DatabaseMenuDao kautta. 
###  Managemennt luokkien ja sovelluksn muiden osien yhteyksiä kuvaava luokka/pakkauskaavio: 

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/LuokkaPakkausKaavio.JPG">

## Päätoiminnallisuudet

Seuraavaksi kuvataan sovelluksen toimintaa parin keskeisen toiminnallisuuden osalta sekvenssikaavioiden avulla. 
### Reseptin lisäys metodin toiminta 
Kunn addRecipe näkymässä on syötetty reseptin nimi sekä ohjeet ja painettu add nappia tapahtuu seuraavaa:
<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/addRecipeSekvenssi.png">

Tapahtumankäsittelijä kutsuu RecipeManagementin metodia createRecipe, joka saa parametrikseen reseptin nimen sekä ohjeen Stringeinä.RecipeManagement luo uuden reseptin ja kutsuu luoka dataBaseRecipeDao addRecipeToDatabase metodia joka saa parametrikseen reseptin. RecipeManagement palauttaa reseptin käyttöliittymälle. Käyttöliittymä kutsuu updateListView metodia joka päivittää etusivun resepti listan. Sekä kutsuu fillComboBox metodia joka päivittää CreateMenuScenen reseptivaihtoehdot. 

### Menun lisäys metodin toiminta 
Kun createMenu näkymässä on syötetty menun nimi sekä valittu menulle tulevat reseptit ja painetaan Create Menu nappia tapahtuu seuraavaa:

<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/createMenuSekvenssi.png">


Tapahtumankäsittelijä kutsuu MenuManagementin metodia createMenu, joka saa parametrikseen menun nimen Srtringinä sekä Listan reseptejä. MenuManagement luo uuden menu olion ja kutsuu databaseMenuDao luokan metodia addMenuToDatabase. Tämä metodi saa parametrikseen menun nimen sekä listan reseptien id numeroita. DatabaseMenuDao luokka tallentaa menun tietokantaan. MenuManagement palauttaa luodun menun käyttöliittymälle. Käyttöliittymä kutsuu metodia updatePickView, joka päivittää näkymän menu listViewin. Lopuksi päivitetty etusivu näkymä näytetään käyttäjälle.


## Tietojen pysyväistallennus 

Pakkauksessa reseptixapp.dao olevat luokat databaseRecipeDao, databaseMenuDao ja databaseConnection pitävät huolen tietojen tallentamisesta tietokantaan

### Tietokannat 

Sovelluksen mukana tulee tietokanta recipesAndMenus.db sekä testi.db. RecipesAndMenus.db toimii käyttäjän reseptien ja menujen tallennuspaikkana. Testi.db tietokantaa käytetään testauksessa. 

Sovelluksessa on helppo muuttaa käytettävää tietokantaa. Käytettävän tietokannan nimi annetaan parametrina FXMLUIluokassa DataBaseConnection luokan konstruktorille. Testausta varten tietokannan voi muuttaa halutessaan testiluokistta. 

Tietokanta sisältää kolme taulua. 
<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/tietokantataulut.png">

Tietokantaan lisätään tietoa ja sieltä haetaan tietoa luokkien databaseRecipeDao sekä databaseMenuDao avulla. 








