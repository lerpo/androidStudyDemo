package com.example.androiddemo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView actionImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        actionImage = findViewById(R.id.action_image);
        actionImage.setImageDrawable(this.getResources().getDrawable(R.drawable.head2));

    }
}