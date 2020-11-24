 # [ReseptiX App](https://github.com/Eddiejjay/ot-harjoitustyo/tree/master/ReseptiXApp)
-  Sovelluksen ensimmäisessä versiossa käyttäjä voi lisätä reseptejään sovellukseen. 
-  Sovelluksen toisessa versiossa sovellukseen on lisätty toiminnallisuus yksittäisten reseptien tarkasteluun sekä reseptin arpomiseen. (tarkemmat tiedon vaatimusmäärittelyssä) 

Sovelluksen seuraava kehitysaskel tulee olemaan graafisen käyttöliittymän päivitys sekä kirjautuminen sovellukseen käyttäjätunnuksella. 
Sovellukseen on myös suunnitteilla seuraavaa: datan tallennus tietokantaan, viikkokohtaisen ruokalistan tekeminen valitsemalla tai arpomalla. 


 ## Dokumentaatio
 - ##### [Vaatimusmäärittely](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/vaatimusm%C3%A4%C3%A4rittely.md)
 - ##### [Työaikakirjanpito](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/tuntikirjanpito.md)
 - ##### [Arkkitehtuurikuvaus](https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/arkkitehtuuri.md)

### Komentorivikomennot 


#### Koodin suoritus 
mvn compile exec:java -Dexec.mainClass=reseptixapp.Main
#### Testien ajo
mvn test
##### Testikattavuusraportti
mvn test jacoco:report

##### Checkstyle-raportti
mvn jxr:jxr checkstyle:checkstyle

