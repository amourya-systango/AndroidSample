package com.example.samplemovieapp.data.api;

import com.example.samplemovieapp.data.model.MovieResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("list.json")
    Call<MovieResponseModel> getMovies();

}
