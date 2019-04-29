package com.example.samplemovieapp.viewmodel;


import com.example.samplemovieapp.data.model.MovieResponseModel;
import com.example.samplemovieapp.data.repository.MovieRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieListViewModel extends ViewModel {
    MutableLiveData<MovieResponseModel> data = new MutableLiveData<>();

    public MovieListViewModel() {
        MovieRepository movieRepository = new MovieRepository();
        data = movieRepository
                .getMovies();
    }

    public MutableLiveData<MovieResponseModel> getData() {
        return data;
    }
}
