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
    List<Genre> getAllUGenres();
    @Insert
    void insertGenre(Genre user);
    @Update
    void updateGenre(Genre user);
    @Delete
    void deleteGenre(Genre user);
    @Query("DELETE FROM Genres;")
    void deleteAllGenres();
}
