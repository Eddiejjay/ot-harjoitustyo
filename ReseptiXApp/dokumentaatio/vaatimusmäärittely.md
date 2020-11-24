 # Vaatimusmäärittely

## Sovelluksen tarkoitus 

Sovelluksen avulla käyttäjä voi katsoa ja lisätä reseptejä. 

## Käyttäjät

Perusversiossa sovelluksessa on yksi käyttäjärooli, normaali käyttäjä.

## Käyttöliittymäluonnos 

Sovelluksen perusversiossa on kolme näkymää. 


<img src="https://github.com/Eddiejjay/ot-harjoitustyo/blob/master/ReseptiXApp/dokumentaatio/Kuvat/Kayttoliittyma.jpg">


Käyttäjän avatessa sovelluksen, se aukeaa Reseptit- näkymään. Aloitusnäkymästä käyttäjä pääsee yksittäisen reseptin näkymään tuplaklikkaamalla ruoan nimeä.
Käyttäjä pääsee siirtymään Uusi resepti- näkymään klikkaamalla nappia Lisää resepti.



## Perusversion tarjoama toiminnallisuus

```diff 
+- käyttäjä voi lisätä uuden reseptin -tehty viikolla 3

+- käyttäjä näkee reseptiensä nimet listalla -tehty viikolla 3

+- käyttäjä voi valita reseptin listalta ja "valitse"- nappia painamalla siirtyy yksittäisen reseptin näkymään - tehty viikolla 4

+- käyttäjä voi halutessaan siiryä satunnaisen reseptin näkymään painamalla "satunnainen"- nappia - tehty viikolla 4
```


## Jatkokehitysideoita 

Sovelluksen perusversion valmistuttua, sovellukseen lisätään toiminnallisuuksia ajan salliessa seuraavasti.
 
 - käyttäjätunnuksen luominen, jolloin sovellusta voivat käyttää useat
eri rekisteröityneet käyttäjät omilla resepteillään

- viikko näkymä, jonka avulla käyttäjä voi suunnitella viikon ruokalistan 
  - reseptien arvonta päivälle 
  - reseption arvonta koko viikolle 

- reseptin muokkaus 

- kommentin lisääminen reseptiin 

- käyttäjätunnuksen poisto 


## Toimintaympäristön rajoitteet
- reseptit tallennetaan paikallisen koneen levylle
- sovellus tulee pystyä suorittamaan, kääntämään ja testaamaan komentoriviltä
käsin Helsingin yliopiston Linux-koneilla tai uusimmat päivitykset
sisältävällä cubbli-linuxilla. 
