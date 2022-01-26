package com.example.androiddemo;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TextViewActivity extends AppCompatActivity {

    private TextView myTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        myTextView = findViewById(R.id.textView);

        myTextView.setText("hello");
        myTextView.setTextSize(20);
    }
}