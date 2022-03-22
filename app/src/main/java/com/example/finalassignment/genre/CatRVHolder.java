package com.example.finalassignment.genre;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.R;

public class CatRVHolder extends RecyclerView.ViewHolder{
    CardView cvCategory;
    ImageView ivCategory;
    TextView tvCatName;

    public CatRVHolder(@NonNull View itemView) {
        super(itemView);

        cvCategory = itemView.findViewById(R.id.cvCategory);
        ivCategory = itemView.findViewById(R.id.ivCategory);
        tvCatName = itemView.findViewById(R.id.tvCatName);

        cvCategory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(),
                        "Card Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
