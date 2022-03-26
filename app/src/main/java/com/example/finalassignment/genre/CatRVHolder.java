package com.example.finalassignment.genre;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.ListActivity;
import com.example.finalassignment.MainActivity;
import com.example.finalassignment.R;

public class CatRVHolder extends RecyclerView.ViewHolder{
    CardView cvCategory;
    ImageView ivCategory;
    TextView tvCatName;
    Context context;

    public CatRVHolder(@NonNull View itemView) {
        super(itemView);

        cvCategory = itemView.findViewById(R.id.cvCategory);
        ivCategory = itemView.findViewById(R.id.ivCategory);
        tvCatName = itemView.findViewById(R.id.tvCatName);
        context = itemView.getContext();

        Intent catIntent = new Intent(context,ListActivity.class);

        cvCategory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view.findViewById(R.id.tvCatName);
                catIntent.putExtra("genreName",textView.getText().toString());
                context.startActivity(catIntent);
            }
        });

    }
}
