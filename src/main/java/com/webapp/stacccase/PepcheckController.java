package com.webapp.stacccase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PepcheckController {

    /**
     * håndterer root (/) og returnerer en startside
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
