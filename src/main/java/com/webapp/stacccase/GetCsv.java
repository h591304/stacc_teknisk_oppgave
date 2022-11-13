package com.webapp.stacccase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class GetCsv {

    /**
     * Metoden henter informasjonen fra pep.csv filen
     */
    public static String getCsv(String person) throws IOException {
        String path = "pep.csv";
        String personName = person.toUpperCase();
        int totalFlags = 0;
        //oppretter BufferedReader objekt for å lese pep.csv filen
        BufferedReader br = new BufferedReader(new FileReader(path));

        String personData = "";
        //while-løkke som sjekker hver linje i filen for treff og
        // stopper etter siste linje
        while((personData = br.readLine()) != null) {
            String[] values = personData.split(",");
            String nameValue = values[2].substring(1, values[2].length()-1).toUpperCase();

            if(personName.equals(nameValue) ||
                    nameValue.contains(personName)) {
                totalFlags += 1;
                System.out.println(nameValue);
            }
        }
        //Finnes ikke personen i .csv filen, er ikke personen flagget

        if(totalFlags == 0) {
            return null;
        }
        return person + " is flagged. Total amount of search results: " + totalFlags;

    }
}
