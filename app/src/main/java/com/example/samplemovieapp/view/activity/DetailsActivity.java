package com.example.samplemovieapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

import com.example.samplemovieapp.R;
import com.example.samplemovieapp.data.model.MovieData;
import com.example.samplemovieapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setExitTransition(new Explode());
        }
        binding=DataBindingUtil.setContentView(this,R.layout.activity_details);
        binding.setMovie((MovieData) getIntent().getExtras().getSerializable("data"));
    }
}
