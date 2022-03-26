package com.example.finalassignment.movie;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.R;

public class ItemRVHolder extends RecyclerView.ViewHolder{
    CardView cvItem;
    ImageView ivItem;
    TextView tvName, tvYear, tvDirector;
    Context context;

    public ItemRVHolder(@NonNull View itemView) {
        super(itemView);
        cvItem = itemView.findViewById(R.id.cvItem);
        ivItem = itemView.findViewById(R.id.ivItem);
        tvName = itemView.findViewById(R.id.tvName);
        tvYear = itemView.findViewById(R.id.tvYear);
        tvDirector = itemView.findViewById(R.id.tvDirector);

        Intent seeMovieIntent = new Intent(context, DetailActivity.class);

        cvItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.tvName);
                seeMovieIntent.putExtra("movieName",textView.getText().toString());
                context.startActivity(seeMovieIntent);
            }
        });
    }
}
