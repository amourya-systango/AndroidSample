package com.example.samplemovieapp.data.model;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.samplemovieapp.utils.GlideApp;

import java.io.Serializable;

import androidx.databinding.BindingAdapter;

public class MovieData implements Serializable {
    private String id;
    private String title;
    private String poster;
    private String summary;
    private String cast;
    private String director;
    private String year;
    private String trailer;
    private String genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String poster) {
        GlideApp.with(imageView.getContext()).load(poster).into(imageView);
    }
}
