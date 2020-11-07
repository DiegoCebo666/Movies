package com.lab1diegocebo.movies.movies.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lab1diegocebo.movies.movies.Model.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

    private static List<Movie> movies = Arrays.asList(new Movie(1, "Pipo", 1970,
            "https://m.media-amazon.com/images/M/MV5BNzhiMzNlOTctZDFjOS00MDlhLTk1ODAtNjM3ZmJjMTgwNmFhXkEyXkFqcGdeQXVyMDQ2MzA4Mw@@._V1_UY268_CR80,0,182,268_AL_.jpg"),
            new Movie(2, "404: Error Not Found", 2011,
            "https://m.media-amazon.com/images/M/MV5BMjc0YWM3MjQtNzNhYy00ZWM5LTk2ODMtNTE0ZmVmYzgzMWMwXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_UY268_CR3,0,182,268_AL_.jpg"));

    @GetMapping("/movies")
    public List<Movie> getMovies(@RequestParam(name="title", required=false, defaultValue="") String title,
                        @RequestParam(name="year", required = false, defaultValue = "0") int year) {
        ArrayList<Movie> moviesFiltered = new ArrayList<>();
        if(title.equals("") && year == 0){
            return movies;
        }
        if(!title.equals("")){
            moviesFiltered = getMoviesByTitle(movies, title);
            if(year != 0){
                moviesFiltered = getMoviesByYear(moviesFiltered, year);
            }
        }else{
            moviesFiltered = getMoviesByYear(movies, year);
        }
        return moviesFiltered;
    }

    public ArrayList<Movie> getMoviesByTitle(List<Movie> movies,String title) {
        ArrayList<Movie> moviesByTitle = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                moviesByTitle.add(movies.get(i));
            }
        }
        return moviesByTitle;
    }

    public ArrayList<Movie> getMoviesByYear(List<Movie> movies, int year) {
        ArrayList<Movie> moviesByYear = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getYear() == year) {
                moviesByYear.add(movies.get(i));
            }
        }
        return moviesByYear;
    }
}