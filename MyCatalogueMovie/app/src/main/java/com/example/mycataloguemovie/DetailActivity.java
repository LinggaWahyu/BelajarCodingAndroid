package com.example.mycataloguemovie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgPhoto;
    private TextView tvName, tvDate, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("key2");

        imgPhoto = findViewById(R.id.detail_photo);
        tvName = findViewById(R.id.detail_name);
        tvDate = findViewById(R.id.detail_date);
        tvDescription = findViewById(R.id.detail_description);

        tvName.setText(movie.getName());
        tvDate.setText(movie.getDate());
        tvDescription.setText(movie.getDescription());
        imgPhoto.setImageResource(movie.getPhoto());
    }
}
