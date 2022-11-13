package com.webapp.stacccase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetCsv {

    /**
     * Metoden henter informasjonen fra pep.csv filen
     */
    public String getCsv(String customer) throws IOException {
        String path = "pep.csv";
        String customerData = "";
        String customerName = customer.toUpperCase();
        int totalFlags = 0;
        //oppretter BufferedReader objekt for å lese pep.csv filen
        BufferedReader br =
                new BufferedReader(new FileReader(path));

        //while-løkke som sjekker hver linje i filen for treff og
        // stopper etter siste linje
        while((customerData = br.readLine()) != null) {
            String[] values = customerData.split(",");
            //sammenligner kundenavn med alle navnene i .csv filen for
            //treff på søk
            if(customerName == values[2].toUpperCase()) {
                customerData += " " + values[11] + ",";
                totalFlags += 1;
            }
        }
        //dersom .csv filen inneholder kundetreff, ser vi antall søketreff og
        //informasjon om kunden
        if(customerData != "") {
            return customerName + " is flagged " + totalFlags + " times";
        }
        return  customerName + " is not flagged.";
    }
}
