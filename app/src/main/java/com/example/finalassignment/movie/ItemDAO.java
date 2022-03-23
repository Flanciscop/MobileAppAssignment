package com.example.finalassignment.movie;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ItemDAO {
    @Insert
    void insertMovie(Movie movie);

    @Query("SELECT * FROM Movies Where id=:id")
    Movie getMovie(int id);

    @Update
    void updateMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);

    @Query("DELETE FROM Movies;")
    void deleteAllUser();
}
