package com.example.finalassignment.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.finalassignment.AppDatabase;
import com.example.finalassignment.DataConverter;
import com.example.finalassignment.R;

public class DetailActivity extends AppCompatActivity {
    ImageView ivPoster;
    EditText etMovie, etYear, etDirector;
    Button btnUpdateItem, btnBackItem;
    ItemDAO movieDAO;
    Movie thisMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPoster = findViewById(R.id.ivPoster);
        etMovie = findViewById(R.id.etMovie);
        etYear = findViewById(R.id.etYear);
        etDirector = findViewById(R.id.etDirector);
        btnUpdateItem = findViewById(R.id.btnUpdateItem);
        btnBackItem = findViewById(R.id.btnBackItem);

        movieDAO = AppDatabase.getDBInstance(this).movieDAO();
        Intent intent = getIntent();
        thisMovie = movieDAO.selectMovie(intent.getStringExtra("movieName"));

        ivPoster.setImageBitmap(DataConverter.converByteArray2Image(
                thisMovie.getPoster()));
        etMovie.setText(thisMovie.getName());
        etYear.setText(thisMovie.getYear());
        etDirector.setText(thisMovie.getDirector());

    }
}