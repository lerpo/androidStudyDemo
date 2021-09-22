package com.example.androiddemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androiddemo.ui.LabelImageIcon;

public class MyUIActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myui);
        LabelImageIcon myIcon = findViewById(R.id.myIcon);
        myIcon.setLabel("驿氪EZR");
        myIcon.setIcon(getResources().getDrawable(R.drawable.ui_helplogo,null));
    }
}