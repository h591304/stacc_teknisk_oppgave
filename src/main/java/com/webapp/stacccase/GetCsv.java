package com.webapp.stacccase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Klassen for å hente og sammenligne informasjon fra .csv fil med brukerinput
 */
public class GetCsv {

    /**
     * Metoden henter informasjonen fra pep.csv filen
     */
    public static String getCsv(String person) throws IOException {
        String path = "pep.csv";
        String personName = person.toUpperCase();
        String dataSet = "";
        int totalFlags = 0;
        //oppretter BufferedReader objekt for å lese pep.csv filen
        BufferedReader br = new BufferedReader(new FileReader(path));

        String personData = "";
        //while-løkke som sjekker hver linje i filen for treff og
        // stopper etter siste linje
        while((personData = br.readLine()) != null) {
            String[] values = personData.split(",");
            String nameValue = values[2].substring(1, values[2].length()-1).toUpperCase();
            String dataValue = values[11].substring(1, values[11].length()-1);

            //sjekker at parameter stemmer overens med data fra .csv fil for søketreff
            if(personName.equals(nameValue) ||
                    nameValue.contains(personName)) {
                //viser alle potensielle posisjoner for en person basert på navn
                if(!dataValue.equals("")) {
                    dataSet += " " + dataValue + ",";
                }
                //antall flags øker med en for hvert søketreff
                totalFlags += 1;
            }
        }
        /**
         * Er ikke personen flagget, returneres null fordi da finnes ingen informasjon
         * om personen
         */
        if(totalFlags == 0) {
            return null;
        }
        return person + " is flagged. Total amount of search results: " + totalFlags
                + ". Possible positions: " + dataSet;

    }
}
