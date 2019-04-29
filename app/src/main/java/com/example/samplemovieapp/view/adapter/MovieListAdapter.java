package com.example.samplemovieapp.view.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samplemovieapp.data.model.MovieData;
import com.example.samplemovieapp.databinding.ItemMovieBinding;
import com.example.samplemovieapp.view.activity.DetailsActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<MovieData> dataList;

    public MovieListAdapter(List<MovieData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding binding = ItemMovieBinding.inflate(inflater);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemMovieBinding itemMovieBinding;

        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            itemMovieBinding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        public void bind(MovieData data) {
            itemMovieBinding.setMovie(data);
            itemMovieBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), DetailsActivity.class);
            intent.putExtra("data", dataList.get(getAdapterPosition()));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                v.getContext().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle());
            }else{
                v.getContext().startActivity(intent);
            }
        }
    }
}
