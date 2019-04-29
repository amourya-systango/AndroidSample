package com.example.samplemovieapp.data.repository;


import com.example.samplemovieapp.data.api.ApiClient;
import com.example.samplemovieapp.data.api.ApiInterface;
import com.example.samplemovieapp.data.model.MovieResponseModel;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private final ApiInterface apiInterface;

    public MovieRepository() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public MutableLiveData<MovieResponseModel> getMovies() {
        final MutableLiveData<MovieResponseModel> data = new MutableLiveData<>();
        Call<MovieResponseModel> movies = apiInterface.getMovies();
        movies.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
