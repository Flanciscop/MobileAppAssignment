package com.example.finalassignment.movie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalassignment.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddItemActivity extends AppCompatActivity {
    final int CAMERA_INTENT = 786;
    ImageView ivAddPoster;
    Bitmap bmpImage;
    Button btnAddPicture, btnAddMovie, btnCancelMovie,btnAddGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ivAddPoster = findViewById(R.id.ivAddPoster);
        btnAddPicture = findViewById(R.id.btnAddPicture);
        btnAddMovie = findViewById(R.id.btnAddMovie);
        btnCancelMovie = findViewById(R.id.btnCancelMovie);
        btnAddGallery = findViewById(R.id.btnAddGallery);

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

            }
        });

        btnCancelMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
}