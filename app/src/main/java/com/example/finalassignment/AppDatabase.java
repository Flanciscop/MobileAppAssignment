package com.example.finalassignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalassignment.genre.CatDAO;
import com.example.finalassignment.genre.Genre;
import com.example.finalassignment.movie.ItemDAO;
import com.example.finalassignment.movie.Movie;

@Database(entities = {Movie.class,Genre.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDB = null;
    public abstract CatDAO genreDao();
    public abstract ItemDAO movieDAO();

    public static synchronized AppDatabase getDBInstance(Context context){
        if(appDB == null){
            appDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "movie_db"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return appDB;
    }
}
