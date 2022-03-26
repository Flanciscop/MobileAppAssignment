package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalassignment.genre.AddCategoryActivity;
import com.example.finalassignment.genre.CatDAO;
import com.example.finalassignment.genre.CatRVAdapter;

public class MainActivity extends AppCompatActivity {
    Button btnAddCat;
    CatDAO genreDao;
    CatRVAdapter genreAdapter;
    RecyclerView rvCategory;
    Intent addCatIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genreDao = AppDatabase.getDBInstance(this).genreDao();
        btnAddCat = findViewById(R.id.btnAddCat);
        genreAdapter = new CatRVAdapter(genreDao.getAllGenres());
        rvCategory = findViewById(R.id.rvCategory);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        rvCategory.setAdapter(genreAdapter);

        addCatIntent = new Intent(this, AddCategoryActivity.class);

        btnAddCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addCatIntent);
            }
        });


    }
}