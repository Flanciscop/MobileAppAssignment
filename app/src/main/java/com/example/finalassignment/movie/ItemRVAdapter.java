package com.example.finalassignment.movie;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.DataConverter;
import com.example.finalassignment.R;

import java.util.List;

public class ItemRVAdapter extends RecyclerView.Adapter<ItemRVHolder> {
    List<Movie> movies;

    public ItemRVAdapter(List<Movie> movies) { this.movies = movies; }

    @NonNull
    @Override
    public ItemRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemRVHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,
                        parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRVHolder holder, int position) {
        Movie movie = movies.get(position);
        //if statement here to check category
        holder.tvName.setText(movie.getName());
        holder.tvDirector.setText(movie.getDirector());
        holder.tvYear.setText(movie.getYear());

        holder.ivItem.setImageBitmap(
                DataConverter.converByteArray2Image(
                        movie.getPoster()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
