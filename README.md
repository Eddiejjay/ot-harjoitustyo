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


#### Koodin suoritus kun repositorio kloonataan GitHubista
mvn compile exec:java -Dexec.mainClass=reseptixapp.Main
#### Testien ajo
mvn test
##### Testikattavuusraportti
mvn test jacoco:report

Kattavuusraporttiin pääsee käsiksi avaamalla selaimella target/site/jacoco/index.html

##### Checkstyle-raportti
mvn jxr:jxr checkstyle:checkstyle

Virheilmoitukset näät avaamalla selaimella tiedoston target/site/checkstyle.html

#### JavaDoc generointi

mvn javadoc:javadoc

JavaDocia pääset tarkastelemaan avaamalla selaimella tiedoston target/site/apidocs/index.html

#### Jar-tiedoston luominen
mvn package

luo kansioon target ajettavan jar-tiedoston ReseptiXApp-1.0-SNAPSHOT.jar

#### Jar- tiedoston ajaminen 
GitHub releasena ladattu: 

java -jar ReseptiXApp.jar 

Ohjelman targer kansiosta komento: 

java -jar ReseptiXApp-1.0-SNAPSHOT.jar 






