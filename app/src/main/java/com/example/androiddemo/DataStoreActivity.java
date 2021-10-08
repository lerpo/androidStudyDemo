package com.example.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androiddemo.datastore.DataBaseUtil;
import com.example.androiddemo.datastore.FileStoreUtil;
import com.example.androiddemo.datastore.SharePrefrenceUtil;

import java.util.ArrayList;

public class DataStoreActivity extends Activity {
    private TextView shaTextView;
    private Button shaAddBtn;
    private TextView fileTextView;
    private Button fileAddBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datastore);
        shaTextView = findViewById(R.id.shaTextView);
        shaAddBtn = findViewById(R.id.shaAddBtn);
        shaAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePrefrenceUtil.writeString(DataStoreActivity.this,"ezr","name", "让零售更简单");
                displayShrData();
            }
        });

        fileTextView = findViewById(R.id.fileTextView);
        fileAddBtn = findViewById(R.id.fileAddBtn);
        fileAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileStoreUtil.saveFile(DataStoreActivity.this,"data.json","{name:\"让生活更美好\"}");
                displayfileData();
            }
        });


        findViewById(R.id.sqlAddBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseUtil.getInstance(DataStoreActivity.this).add("张三",22,"男");
                displaySqlData();
            }
        });

        findViewById(R.id.sqlDeleteBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseUtil.getInstance(DataStoreActivity.this).delete("张三");
                displaySqlData();
            }
        });

        findViewById(R.id.sqlUpdateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseUtil.getInstance(DataStoreActivity.this).update("张三","王五");
                displaySqlData();
            }
        });

        findViewById(R.id.sqlQueryBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySqlData();
            }
        });
    }

    private void displayShrData() {
        shaTextView.setText(SharePrefrenceUtil.readString(DataStoreActivity.this,"ezr","name"));
    }

    private void displayfileData() {
        String fileString = FileStoreUtil.readFile(this,"data.json");
        fileTextView.setText(fileString);
    }

    private void displaySqlData(){
        ArrayList datalist = DataBaseUtil.getInstance(DataStoreActivity.this).query();
        String userInfo = "";
        for(int i = 0; i < datalist.size(); i++) {
            userInfo += "\n" + (String) datalist.get(i);

        }
        ((TextView)findViewById(R.id.sqlTextView)).setText(userInfo);
    }
}
