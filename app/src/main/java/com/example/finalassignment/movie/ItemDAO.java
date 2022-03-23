package com.example.finalassignment.movie;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finalassignment.genre.Genre;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("Select * from Movies")
    List<Movie> getAllMovies();
    @Insert
    void insertMovie(Movie movie);
    @Update
    void updateMovie(Movie movie);
    @Delete
    void deleteMovie(Movie movie);
    @Query("DELETE FROM Movies;")
    void deleteAllMovies();
}
