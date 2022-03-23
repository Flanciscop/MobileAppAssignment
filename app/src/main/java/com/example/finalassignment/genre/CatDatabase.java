package com.example.finalassignment.genre;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Genre.class},
        version = 1, exportSchema = false)
public abstract class CatDatabase extends RoomDatabase {
    private static CatDatabase genreDB = null;
    public abstract CatDAO genreDao();
    public static synchronized CatDatabase getDBInstance(Context context){
        if(genreDB == null){
            genreDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    CatDatabase.class,
                    "user_db"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return genreDB;
    }
}
