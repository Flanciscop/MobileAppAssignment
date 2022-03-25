package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalassignment.movie.AddItemActivity;
import com.example.finalassignment.movie.DetailActivity;
import com.example.finalassignment.movie.ItemDAO;
import com.example.finalassignment.movie.ItemRVAdapter;

public class ListActivity extends AppCompatActivity {
    Button btnAddItem;
    ItemDAO movieDAO;
    ItemRVAdapter movieAdapter;
    RecyclerView rvItem;
    Intent addMovieIntent,seeMovieIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        movieDAO = AppDatabase.getDBInstance(this).movieDAO();
        btnAddItem = findViewById(R.id.btnAddItem);
        movieAdapter = new ItemRVAdapter(movieDAO.getAllMovies());
        rvItem = findViewById(R.id.rvCategory);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setAdapter(movieAdapter);

        addMovieIntent = new Intent(this, AddItemActivity.class);
        seeMovieIntent = new Intent(this, DetailActivity.class);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addMovieIntent);
            }
        });

        rvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(seeMovieIntent);
            }
        });
    }
}