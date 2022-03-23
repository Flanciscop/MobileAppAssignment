package com.example.finalassignment.movie;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Movie.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    private static ItemDatabase movieDB = null;
    public abstract ItemDAO movieDAO();

    public static synchronized ItemDatabase getDBInstance(Context context){
        if(movieDB == null){
            movieDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ItemDatabase.class,
                    "user_db"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return movieDB;
    }
}
