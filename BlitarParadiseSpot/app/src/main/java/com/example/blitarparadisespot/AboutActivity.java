package com.example.blitarparadisespot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AboutActivity extends AppCompatActivity {

    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imgPhoto = findViewById(R.id.about_img_photo);

        Glide.with(this).load(R.drawable.about_picture).into(imgPhoto);
    }
}
