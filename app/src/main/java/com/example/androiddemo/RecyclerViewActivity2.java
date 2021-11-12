package com.example.androiddemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddemo.adapter.MyRecyclerViewAdapter2;
import com.example.androiddemo.swipe.helper.WeSwipe;
import com.example.androiddemo.swipe.helper.WeSwipeHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RecyclerViewActivity2 extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private MyRecyclerViewAdapter2 mAdapter;
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
        ArrayList<Map<String,String>> dataLists=new ArrayList<Map<String,String>>(100);
        for (int i=0;i<100;i++){
            int index=i+1;
            Map userInfo = new HashMap();
            int randomId =  new Random().nextInt(4)+1;
            int imageID = 0;
            String talk = "";
            String name ="";
            switch (randomId){
                case 1: {
                    imageID = R.drawable.head1;
                    talk = "中午吃的什么饭，味道怎么样";
                    name = "赵晓壮";
                }break;
                case 2: {
                    imageID = R.drawable.head2;
                    talk = "几点下班，今天又要加班了么";
                    name = "于文峰";
                } break;
                case 3: {
                    imageID = R.drawable.head3;
                    talk = "你闺蜜是哪的，男的女的，喜欢逛街么";
                    name = "王扎楠";
                } break;
                case 4: {
                    imageID = R.drawable.head4;
                    talk = "平时在家你都喜欢干些啥？";
                    name = "刘美恩";
                }
            }
            userInfo.put("head",imageID);
            userInfo.put("name",name);
            userInfo.put("talk",talk);
            userInfo.put("time","上午11:37");
            dataLists.add(userInfo);
        }
        mAdapter = new MyRecyclerViewAdapter2(this,dataLists);
        myRecyclerView.setAdapter(mAdapter);
        WeSwipe weSwipe = WeSwipe.attach(myRecyclerView).setType(WeSwipeHelper.SWIPE_ITEM_TYPE_FLOWING);
        mAdapter.setWeSwipe(weSwipe);




    }
}