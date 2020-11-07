package com.lab1diegocebo.movies.movies.API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class LangController {
    @GetMapping("/langHtml")
    public String langHtml(){
        return "movies";
    }
}
