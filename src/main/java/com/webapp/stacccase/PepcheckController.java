package com.webapp.stacccase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class PepcheckController{

    /**
     * håndterer root (/) og returnerer en startside
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Metode som utfører søk og sjekk av brukeren
     * @return
     */
    @PostMapping("/search")
    public static String userCheck(Model model, @RequestParam(name = "person") String person)
            throws IOException {

        //henter data fra getCsv og google informasjon og lagrer i to variabler
        String getCsv = GetCsv.getCsv(person);
        String googleInfo = GetInfo.getGoogleInfo(person);

        /**
         * legger til personinformasjon og antall søøketreff til model-objektet
         * dersom personen er flagget
         */
        if(getCsv != null) {
            model.addAttribute("personInfo", getCsv);
            model.addAttribute("googleInfo", googleInfo);
        }
        //else dersom personen ikke er flagget
        else {
            model.addAttribute("personInfo",
                    person + " is not flagged");
        }
        return "info";
    }

}
