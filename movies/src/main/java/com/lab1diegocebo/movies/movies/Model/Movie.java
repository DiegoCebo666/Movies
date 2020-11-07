package com.lab1diegocebo.movies.movies.Model;

public class Movie {
    public Movie(){}

    public Movie(int id, String title, int year, String img){
        this.id = id;
        this.title = title;
        this.year = year;
        this.img = img;
    }

    private int id;
    private String title;
    private int year;
    private String img;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getImg() {
        return img;
    }public void setImg(String img) {
        this.img = img;
    }
}