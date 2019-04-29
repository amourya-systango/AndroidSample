package com.example.samplemovieapp.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.samplemovieapp.R;
import com.example.samplemovieapp.data.model.MovieData;
import com.example.samplemovieapp.data.model.MovieResponseModel;
import com.example.samplemovieapp.databinding.ActivityMainBinding;
import com.example.samplemovieapp.view.adapter.MovieListAdapter;
import com.example.samplemovieapp.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    private MovieListAdapter adapter;
    List<MovieData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new MovieListAdapter(list);
        activityMainBinding.recyclerView.setAdapter(adapter);
        activityMainBinding.progressCircular.setVisibility(View.VISIBLE);
        ViewModelProviders.of(this).get(MovieListViewModel.class).getData().observe(this, new Observer<MovieResponseModel>() {
            @Override
            public void onChanged(MovieResponseModel movieResponseModel) {
                if (movieResponseModel != null) {
                    if (movieResponseModel.getData() != null) {
                        list.clear();
                        list.addAll(movieResponseModel.getData());
                        adapter.notifyDataSetChanged();
                        activityMainBinding.progressCircular.setVisibility(View.GONE);
                    }
                }

            }
        });

    }
}
