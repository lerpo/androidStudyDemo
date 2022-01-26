package com.example.androiddemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.androiddemo.datastore.DataBaseUtil;
import com.example.androiddemo.datastore.FileStoreUtil;
import com.example.androiddemo.datastore.SharePrefrenceUtil;
import com.example.androiddemo.model.RequestModel;
import com.example.androiddemo.model.UserModel;
import com.example.androiddemo.net.NetCallback;
import com.example.androiddemo.net.OkHttpUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttp;

public class NetRequestActivity extends Activity {
    private Button shaAddBtn;
    private TextView shaTextView;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {
                Bundle bundle = msg.getData();
                String userInfo = bundle.getString("userInfo");
                shaTextView.setText(userInfo);
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_request);
        shaAddBtn = findViewById(R.id.shaAddBtn);
        shaTextView = findViewById(R.id.shaTextView);
        shaAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.getInstance().getRequest("http://192.168.12.213:1000/v1/base/getMember", "GET", new  NetCallback() {
                    @Override
                    public void callBack(Object obj) {
                        System.out.println(obj);
                        RequestModel result = (RequestModel) JSON.parseObject(obj.toString(), RequestModel.class);
                        List<UserModel> dataList =JSON.parseObject(result.getData().getRows(), new TypeReference<List<UserModel>>(){});
                        StringBuilder buffer = new StringBuilder();
                        for(int i = 0; i < dataList.size(); i++) {
                            buffer.append(dataList.get(i).getName());
                            buffer.append("\n");
                        }

//                        shaTextView.setText(buffer.toString());
                        Message msg = Message.obtain();
                        msg.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("userInfo", buffer.toString());
                        msg.setData(bundle);
                        handler.sendMessage(msg);
                    }
                });
            }
        });
    }
}
