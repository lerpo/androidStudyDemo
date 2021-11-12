package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void ViewAction(View view){
        startActivity(new Intent(this, ViewActivity.class));
    }

    public void TextViewAction(View view){
        startActivity(new Intent(this, TextViewActivity.class));
    }

    public void EditTextAction(View view){
        startActivity(new Intent(this, EditTextActivity.class));
    }

    public void ImageViewAction(View view){
        startActivity(new Intent(this, ImageViewActivity.class));
    }

    public void RecyclerViewAction(View view){
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void RecyclerView2Action(View view){
        startActivity(new Intent(this, RecyclerViewActivity2.class));
    }
    public void UIViewAction(View view){
        startActivity(new Intent(this, MyUIActivity.class));
    }

    public void DataStoreAction(View view){
        startActivity(new Intent(this, DataStoreActivity.class));
    }


}