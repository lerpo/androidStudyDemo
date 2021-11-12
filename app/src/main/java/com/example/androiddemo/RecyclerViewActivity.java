package com.example.androiddemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddemo.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        //开始设置RecyclerView
        myRecyclerView=(RecyclerView)this.findViewById(R.id.myRecycleView);
        //设置固定大小
        myRecyclerView.setHasFixedSize(true);
        //创建线性布局
        mLayoutManager = new LinearLayoutManager(this);
        //创建线性布局
//        mLayoutManager = new GridLayoutManager(this,4); //第二个参数为网格的列数
        //给RecyclerView设置布局管理器
        myRecyclerView.setLayoutManager(mLayoutManager);
        //创建适配器，并且设置
        ArrayList<String> dataLists=new ArrayList<String>(100);
        for (int i=0;i<100;i++){
            int index=i+1;
            dataLists.add("EZR 让零售更简单 "+ index);
        }
        mAdapter = new MyRecyclerViewAdapter(this,dataLists);
        myRecyclerView.setAdapter(mAdapter);
    }
}