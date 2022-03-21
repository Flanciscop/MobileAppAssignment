package com.example.finalassignment.movie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalassignment.R;

public class AddItemActivity extends AppCompatActivity {
    final int CAMERA_INTENT = 786;
    ImageView ivAddPoster;
    Bitmap bmpImage;
    Button btnAddPicture, btnAddMovie, btnCancelMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ivAddPoster = findViewById(R.id.ivAddPoster);
        btnAddPicture = findViewById(R.id.btnAddPicture);
        btnAddMovie = findViewById(R.id.btnAddMovie);
        btnCancelMovie = findViewById(R.id.btnCancelMovie);

        btnAddPicture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(intent, CAMERA_INTENT);
                }
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
        }
    }
}