package com.lab1diegocebo.movies.movies.API;

import java.util.ArrayList;
import java.util.List;

import com.lab1diegocebo.movies.movies.Model.Movie;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

    private static ArrayList<Movie> movies = new ArrayList<>();
    
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

    @PostMapping("movies")
    public Movie Add(@RequestBody Movie newMovie) {
        movies.add(newMovie);
        return newMovie;
    }

    @PutMapping("movies/{id}")
    public Movie Update(@RequestBody Movie updateMovie, @PathVariable("id") int id) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                if(!updateMovie.getTitle().equals("")){
                    movies.get(i).setTitle(updateMovie.getTitle());
                }
                if(updateMovie.getYear() != 0){
                    movies.get(i).setYear(updateMovie.getYear());
                }
                if(!updateMovie.getImg().equals("")){
                    movies.get(i).setImg(updateMovie.getImg());
                }
                return updateMovie;
            }
        }
        return updateMovie;
    }

    @DeleteMapping("movies/{id}")
    public int Delete(@PathVariable("id") int id){
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getId() == id){
                movies.remove(i);
                return 1;
            }
        }
        return 0;
    }
}