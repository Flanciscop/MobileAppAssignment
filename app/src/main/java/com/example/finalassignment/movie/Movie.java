package com.example.finalassignment.movie;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.finalassignment.genre.Genre;

/*

        ,foreignKeys = @ForeignKey(entity = Genre.class,
            parentColumns = "name",
            childColumns = "genreName",
            onDelete = ForeignKey.NO_ACTION)
 */
@Entity(tableName = "Movies")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    int id;
    String genreName;
    String name;
    String director;
    String year;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] poster;

    public Movie(int id, String genreName, String name, String director, String year, byte[] poster) {
        this.id = id;
        this.genreName = genreName;
        this.name = name;
        this.director = director;
        this.year = year;
        this.poster = poster;
    }

    public Movie() {

    }
    public Movie(String genreName, String name, String director, String year, byte[] poster) {
        this.genreName = genreName;
        this.name = name;
        this.director = director;
        this.year = year;
        this.poster = poster;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
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
