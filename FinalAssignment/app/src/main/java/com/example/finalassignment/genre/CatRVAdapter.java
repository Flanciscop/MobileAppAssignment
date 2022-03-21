package com.example.finalassignment.genre;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.DataConverter;
import com.example.finalassignment.R;

import java.util.List;

public class CatRVAdapter extends RecyclerView.Adapter<CatRVHolder> {
    List<Genre> genres;

    public CatRVAdapter(List<Genre> genres) {
        this.genres = genres;
    }

    @NonNull
    @Override
    public CatRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CatRVHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_category,
                        parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CatRVHolder holder, int position) {
        Genre genre = genres.get(position);
        holder.tvCatName.setText(genre.getName());
        holder.ivCategory.setImageBitmap(
                DataConverter.converByteArray2Image(
                        genre.getGenreImage()));
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }
}
