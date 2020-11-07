package com.lab1diegocebo.movies.movies.API;

import java.util.Arrays;
import java.util.List;

import com.lab1diegocebo.movies.movies.Model.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

    private static List<Movie> movies = Arrays.asList(new Movie(1, "Pipo", 1970,
            "https://m.media-amazon.com/images/M/MV5BNzhiMzNlOTctZDFjOS00MDlhLTk1ODAtNjM3ZmJjMTgwNmFhXkEyXkFqcGdeQXVyMDQ2MzA4Mw@@._V1_UY268_CR80,0,182,268_AL_.jpg"),
            new Movie(2, "404: Error Not Found", 2011,
                    "https://m.media-amazon.com/images/M/MV5BMjc0YWM3MjQtNzNhYy00ZWM5LTk2ODMtNTE0ZmVmYzgzMWMwXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_UY268_CR3,0,182,268_AL_.jpg"));

   

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movies;
    }
}