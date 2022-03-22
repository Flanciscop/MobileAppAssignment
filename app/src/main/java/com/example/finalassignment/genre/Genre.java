package com.example.finalassignment.genre;

public class Genre {
    int id;
    String name;
    byte[] genreImage;

    public Genre(int id, String name, byte[] genreImage) {
        this.id = id;
        this.name = name;
        this.genreImage = genreImage;
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
    public byte[] getGenreImage() {
        return genreImage;
    }
    public void setGenreImage(byte[] genreImage) {
        this.genreImage = genreImage;
    }
}
