package com.lab1diegocebo.movies.movies.API;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LangController {
    @GetMapping("lang")
    public String test(Locale lang){
        var test = ResourceBundle.getBundle("i18n\\movies", lang);
        return test.getString("Movie.test");
    }

    @GetMapping("langHtml")
    public String Test(){
        return "movies";
    }
}