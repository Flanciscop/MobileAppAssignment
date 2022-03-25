package com.example.finalassignment.genre;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Genres", indices = @Index(value = {"name"},unique = true))
public class Genre {
    @PrimaryKey(autoGenerate = true)
    int gid;
    String name;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] genreImage;

    public Genre(int gid, String name, byte[] genreImage) {
        this.gid = gid;
        this.name = name;
        this.genreImage = genreImage;
    }

    public Genre() {

    }

    public int getId() {
        return gid;
    }
    public void setId(int id) {
        this.gid = gid;
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
