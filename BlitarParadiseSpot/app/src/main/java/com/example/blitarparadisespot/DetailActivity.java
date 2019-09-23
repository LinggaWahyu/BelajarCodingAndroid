package com.example.blitarparadisespot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgPhoto;
    private TextView Name;
    private TextView Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Place place = intent.getParcelableExtra("key");

        imgPhoto = findViewById(R.id.detail_photo);
        Name = findViewById(R.id.detail_name);
        Description = findViewById(R.id.detail_description);

        Glide.with(this).load(place.getPhoto()).into(imgPhoto);
        Name.setText(place.getName());
        Description.setText(place.getAddres());
    }
}
