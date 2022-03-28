package com.example.finalassignment.genre;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CatDAO {
    @Query("Select * from Genres")
    List<Genre> getAllGenres();
    @Insert
    void insertGenre(Genre genre);
    @Update
    void updateGenre(Genre genre);
    @Delete
    void deleteGenre(Genre genre);
    @Query("DELETE FROM Genres;")
    void deleteAllGenres();

    @Query("Select name from Genres")
    List<String> getGenreList();
}
