package com.example.finalassignment.genre;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalassignment.AppDatabase;
import com.example.finalassignment.DataConverter;
import com.example.finalassignment.MainActivity;
import com.example.finalassignment.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddCategoryActivity extends AppCompatActivity {
    final int CAMERA_INTENT = 786;
    ImageView ivGenreImage;
    Bitmap bmpImage;
    Button btnPicture,btnSubmitGenre,btnCancelGenre, btnGallery;
    CatDAO genreDao;
    EditText etAddGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        genreDao = AppDatabase.getDBInstance(this).genreDAO();
        ivGenreImage = findViewById(R.id.ivGenreImage);
        btnPicture = findViewById(R.id.btnPicture);
        btnCancelGenre = findViewById(R.id.btnCancelGenre);
        btnSubmitGenre = findViewById(R.id.btnSubmitGenre);
        etAddGenre = findViewById(R.id.etAddGenre);
        btnGallery = findViewById(R.id.btnGallery);

        Intent intent = new Intent(this, MainActivity.class);

        btnPicture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(intent, CAMERA_INTENT);
                }
            }
        });
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_GET_CONTENT);
                intent1.setType("image/*");

                startActivityForResult(Intent.createChooser(intent1,"Pick an image"), 1);
            }
        });

        btnCancelGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        btnSubmitGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addGenre();
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
                    ivGenreImage.setImageBitmap(bmpImage);
                }else{
                    Toast.makeText(
                            this,
                            "Bitmap is NULL",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            } else {
                Toast.makeText(
                        this,
                        "Result not OK",
                        Toast.LENGTH_SHORT
                ).show();
            }
        } else if(requestCode == 1){
            if (resultCode == RESULT_OK ){
                try {
                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
                    bmpImage = BitmapFactory.decodeStream(inputStream);
                    ivGenreImage.setImageBitmap(bmpImage);
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void addGenre(){
        if(etAddGenre.getText().toString().isEmpty() ||
                bmpImage == null){
            Toast.makeText(
                    this,
                    "Genre Data is missing",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Genre genre = new Genre();
            genre.setName(etAddGenre.getText().toString());
            genre.setGenreImage(DataConverter.convertImage2ByteArray(bmpImage));
            genreDao.insertGenre(genre);
            Toast.makeText(
                    this,
                    "Genre Added",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}