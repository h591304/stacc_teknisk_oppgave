package com.webapp.stacccase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class GetInfo {

    /**
     * Metoden henter informasjon fra googlesøk om personen som skal pep-sjekkes
     */
    public static String getGoogleInfo(String personName) throws IOException {
        //Erstatter whitespaces i navnesøk med + for å få riktig google-url
        String nameWithSpace = personName.replace(' ', '+');
        String webUrl = "https://www.google.com/search?q=";

        //tar url og sender en HTTP request og parser resultatet ved bruk av Jsoup
        Document doc = Jsoup.connect(webUrl + nameWithSpace).get();

        //henter og printer ut informasjon fra info seksjonen på google
        Element resultData = doc.select("div[class=kno-rdesc]").first();

        //returnerer informasjonen derosom det finnes informasjon om personen på google
        if(resultData != null) {
            String resultInfo = resultData.text();
            return "Information from google search: " + resultInfo;
        }
        //returnerer null hvis ikke
        return null;
    }
}