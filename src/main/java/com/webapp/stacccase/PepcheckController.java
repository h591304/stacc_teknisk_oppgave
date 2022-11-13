package com.webapp.stacccase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class PepcheckController {

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
    public static String userCheck(Model model) throws IOException {

        String person = "knut hamsun";

        String getCsv = GetCsv.getCsv(person);
        String googleInfo = GetInfo.getGoogleInfo(person);

        if(getCsv != null) {
            model.addAttribute("personInfo", getCsv);
            model.addAttribute("googleInfo", googleInfo);
        }
        else {
            model.addAttribute("personInfo",
                    person + " is not flagged");
            model.addAttribute("googleInfo"
                    , "There aren't any results on " + person + "!");
        }

        return "info";
    }

}
