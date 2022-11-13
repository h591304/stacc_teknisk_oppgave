package com.webapp.stacccase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetCsv {

    /**
     * Metoden henter informasjonen fra pep.csv filen
     */
    public static String getCsv(String person) throws IOException {
        String path = "pep.csv";
        String personData = "";
        String personName = person.toLowerCase();
        int totalFlags = 0;
        //oppretter BufferedReader objekt for å lese pep.csv filen
        BufferedReader br =
                new BufferedReader(new FileReader(path));

        //while-løkke som sjekker hver linje i filen for treff og
        // stopper etter siste linje
        while((personData = br.readLine()) != null) {
            String[] values = personData.split(",");
            //sammenligner kundenavn med alle navnene i .csv filen for
            //treff på søk
            if(personName == values[2].toLowerCase()) {
                personData += " " + values[11] + ",";
                totalFlags += 1;
            }
        }
        //Finnes ikke personen i .csv filen, er ikke personen flagget
        switch(totalFlags) {
            case 0:
                return null;
            default:
                return personName + " is flagged " + totalFlags + " times";
        }
    }
}
