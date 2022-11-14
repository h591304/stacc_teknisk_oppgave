# Stacc_teknisk_oppgave
Kodeoppgave til tekniks intervju H22

## Oppgavebeskrivelse
Jeg valgte oppgave a) der jeg skulle lage en webapplikasjon som lar brukeren se om personen er flagget (får søketreff) og utføre en pep-sjekk på personen og viser
litt informasjon fra googlesøk (gitt at personen er flagget).

## Hvordan kjøre prosjektet
Har lagt til webapplikasjonen til heroku: 

### Setup for egen datamaskin
Requirements:
  - minst Python3 (helst nyere)
  - JDK 17 (kan ikke kjøre uten) For intellij kan versjonen endres i Files -> Project Structure -> Project -> New... under Project SDK. Her må java versjon 17 være installert et sted på maskinen.

INSTRUKSJON FOR INTELLIJ: En jsoup.jar fil kreves og den kan lastes ned på datamaskin og lagt til File -> Project Structure -> Modules -> JARs or directories(+ tegn i midten i modules-tab) også finne stedet på maskinen .jar filen er lagret.

For å kjøre applikasjonen, må StaccaseApplication kjøres og siden blir da tilgjenglig på http://localhost:8080/

## Kommentarer
For informasjonshenting ved pep-check, implementerte jeg bare en metode for henting av informasjon fra google søk fordi jeg hadde ikke mer tid i helgen til å implementere scraping fra flere nettsider, men dette kan gjøres enkelt på isj- samme måte som jeg gjorde for google. Forstod også på oppgaven at informasjon skulle kun hentes fra nettsider dersom personen ble flagget.

## Task description
Som sagt i oppgavebeskrivelsen, valgte jeg å gjøre oppgave a), men hadde desverre ikke tid til å se på resten av oppgavene i helgen.

## Comments
Jeg synes oppgaven var en interessant og spennende oppgave. Jeg har kun hatt et kurs i webapplikasjoner H2021 der vi brukte Servlets som jeg husker var ekstremt ineffektivt og knotete å holde på med. Jeg har med andre ord aldri vært borti Spring boot (eller jsoup) før og utnyttet dermed muligheten til å lære meg på veldig kort tid mens jeg gjennomførte denne casen. Jeg er alt i alt fornøyd og har lært masse nytt i prosessen. :)))
