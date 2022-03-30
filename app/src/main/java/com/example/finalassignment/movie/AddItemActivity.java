package com.example.finalassignment.movie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finalassignment.AppDatabase;
import com.example.finalassignment.DataConverter;
import com.example.finalassignment.MainActivity;
import com.example.finalassignment.R;
import com.example.finalassignment.genre.CatDAO;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {
    final int CAMERA_INTENT = 786;
    ImageView ivAddPoster;
    Bitmap bmpImage;
    Button btnAddPicture, btnAddMovie, btnCancelMovie,btnAddGallery;
    EditText etAddMovie, etAddYear, etAddDirector;
    ItemDAO movieDAO;
    CatDAO genreDAO;
    Spinner spnGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        movieDAO = AppDatabase.getDBInstance(this).movieDAO();
        genreDAO = AppDatabase.getDBInstance(this).genreDAO();

        ivAddPoster = findViewById(R.id.ivAddPoster);
        btnAddPicture = findViewById(R.id.btnAddPicture);
        btnAddMovie = findViewById(R.id.btnAddMovie);
        btnCancelMovie = findViewById(R.id.btnCancelMovie);
        btnAddGallery = findViewById(R.id.btnAddGallery);
        etAddMovie = findViewById(R.id.etAddMovie);
        etAddYear = findViewById(R.id.etAddYear);
        etAddDirector = findViewById(R.id.etAddDirector);

        spnGenre = findViewById(R.id.spnGenre);
        List<String> items = genreDAO.getGenreList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spnGenre.setAdapter(adapter);

        Intent intent1 = new Intent(this, MainActivity.class);


        btnAddPicture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(intent, CAMERA_INTENT);
                }
            }
        });
        btnAddGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_GET_CONTENT);
                intent1.setType("image/*");
                startActivityForResult(Intent.createChooser(intent1,"Pick an image"), 1);
            }
        });

        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMovie();
            }
        });
        btnCancelMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAMERA_INTENT){
            if( resultCode == Activity.RESULT_OK){
                bmpImage = (Bitmap) data.getExtras().get("data");
                if(bmpImage != null){
                    ivAddPoster.setImageBitmap(bmpImage);
                }else{
                    Toast.makeText(this, "Bitmap is NULL", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Result not OK", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == 1){
            if (resultCode == RESULT_OK ){
                try {
                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
                    bmpImage = BitmapFactory.decodeStream(inputStream);
                    ivAddPoster.setImageBitmap(bmpImage);
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
    }


    public void addMovie(){
        if(etAddMovie.getText().toString().isEmpty() ||
                etAddYear.getText().toString().isEmpty() ||
                etAddDirector.getText().toString().isEmpty() ||
                bmpImage == null){
            Toast.makeText(
                    this,
                    "Movie Data is missing",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Movie movie = new Movie();
            movie.setName(etAddMovie.getText().toString());
            movie.setYear(etAddYear.getText().toString());
            movie.setDirector(etAddDirector.getText().toString());
            movie.setGenreName(spnGenre.getSelectedItem().toString());
            movie.setPoster(DataConverter.convertImage2ByteArray(bmpImage));
            movieDAO.insertMovie(movie);
            Toast.makeText(
                    this,
                    "Movie Added",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}