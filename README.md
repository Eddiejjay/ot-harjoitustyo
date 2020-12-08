 # [ReseptiX App](https://github.com/Eddiejjay/ot-harjoitustyo/tree/master/ReseptiXApp)
 
 Sovelluksen avulla käyttäjä voi lisätä ja tarkastella omia reseptejään sekä luoda viikkokohtaisen ruokalistan. 
 
-  Sovelluksen ensimmäisessä versiossa käyttäjä voi lisätä reseptejään sovellukseen. 
-  Sovelluksen toisessa versiossa sovellukseen on lisätty toiminnallisuus yksittäisten reseptien tarkasteluun sekä reseptin arpomiseen. (tarkemmat tiedon vaatimusmäärittelyssä) 
-  Sovelluksen kolmannessa versiossa graafinen käyttöliittymä uusittiin täysin Java FXML käyttäen sekä lisättiin toiminnallisuus viikon menun luomiseen

Sovelluksen seuraava kehitysaskel tulee olemaan menu toiminnallisuuden viimeistely mm. menun tarkastelu sekä mahdollisuus arpoa reseptejä eri päiville.  Jos aikaa riittää sovellukseen ideoidaan lisää mielekästä käyttäjäystävällistä toiminnallisuutta. Sovellukseen on myös suunnitteilla datan tallennus tietokantaan.


 ## Dokumentaatio
 - ##### [Vaatimusmäärittely](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/vaatimusm%C3%A4%C3%A4rittely.md)
 - ##### [Työaikakirjanpito](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/tuntikirjanpito.md)
 - ##### [Arkkitehtuurikuvaus](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/arkkitehtuuri.md)
 
 ## Releaset
 [Viikko 6](https://github.com/Eddiejjay/ot-harjoitustyo/releases/tag/jee)
 

### Komentorivikomennot 


#### Koodin suoritus 
mvn compile exec:java -Dexec.mainClass=reseptixapp.Main
#### Testien ajo
mvn test
##### Testikattavuusraportti
mvn test jacoco:report

##### Checkstyle-raportti
mvn jxr:jxr checkstyle:checkstyle

#### Jar-tiedoston luominen
mvn package

#### Jar- tiedoston ajaminen 
GitHub releasena ladattu: 

java -jar ReseptiXApp.jar 

Ohjelman targer kansiosta komento: 

java -jar ReseptiXApp-1.0-SNAPSHOT.jar 






