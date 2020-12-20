 # [ReseptiX App](https://github.com/Eddiejjay/ot-harjoitustyo/tree/master/ReseptiXApp)
 
 Sovelluksen avulla käyttäjä voi lisätä ja tarkastella omia reseptejään sekä luoda viikkokohtaisen ruokalistan. 


 ## Dokumentaatio
 - ##### [Käyttöohje](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/kayttoohje.md)
 - ##### [Vaatimusmäärittely](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/vaatimusm%C3%A4%C3%A4rittely.md)
 - ##### [Arkkitehtuurikuvaus](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/arkkitehtuuri.md)
 - ##### [Testausdokumentti](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/testaus.md) 
 - ##### [Työaikakirjanpito](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/tuntikirjanpito.md)
 
 ## Releaset
 [Final release](https://github.com/Eddiejjay/ot-harjoitustyo/releases/tag/FinalRelease)
 

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






