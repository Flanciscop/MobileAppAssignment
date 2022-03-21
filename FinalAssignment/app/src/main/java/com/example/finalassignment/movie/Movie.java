package com.example.finalassignment.movie;

public class Movie {
    int id;
    String name;
    String director;
    String year;
    byte[] poster;

    public Movie(int id, String name, String director, String year, byte[] poster) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }
}
