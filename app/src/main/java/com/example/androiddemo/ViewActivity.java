package com.example.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    public void linearLayoutAction(View view){
       startActivity(new Intent(this, LinnerLayoutActivity.class));
    }

    public void relativeLayoutAction(View view){
        startActivity(new Intent(this, RelativeLayoutActivity.class));
    }

    public void constraintLayoutAction(View view){
        startActivity(new Intent(this, ConstraintLayoutActivity.class));
    }

    public void frameLayoutAction(View view){
        startActivity(new Intent(this, FrameLayoutActivity.class));
    }
}