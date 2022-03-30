package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalassignment.movie.AddItemActivity;
import com.example.finalassignment.movie.DetailActivity;
import com.example.finalassignment.movie.ItemDAO;
import com.example.finalassignment.movie.ItemRVAdapter;

public class ListActivity extends AppCompatActivity {
    Button btnAddItem;
    ItemDAO movieDAO;
    ItemRVAdapter movieAdapter;
    RecyclerView rvItem;
    Intent addMovieIntent, intent;
    TextView tvGenreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        intent = getIntent();

        movieDAO = AppDatabase.getDBInstance(this).movieDAO();
        btnAddItem = findViewById(R.id.btnAddItem);
        //movieAdapter = new ItemRVAdapter(movieDAO.getAllMovies());
        movieAdapter = new ItemRVAdapter(movieDAO.getMovieByGenre(intent.getStringExtra("genreName")));
        rvItem = findViewById(R.id.rvItem);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setAdapter(movieAdapter);

        tvGenreList = findViewById(R.id.tvGenreList);

        tvGenreList.setText(intent.getStringExtra("genreName")+" Movies");

        addMovieIntent = new Intent(this, AddItemActivity.class);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addMovieIntent);
            }
        });
    }
}