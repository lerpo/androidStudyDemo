package com.example.androiddemo.net;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpUtils {
    private final OkHttpClient client = new OkHttpClient();
    private static OkHttpUtils instance;
    private OkHttpUtils(){}
    public static synchronized OkHttpUtils getInstance() {
        if(instance == null) {
            instance = new OkHttpUtils();
        }
        return instance;
    }
    public void getRequest(String reqUrl, String reqMethod, NetCallback callback){
            Request request = new Request.Builder()
                    .url(reqUrl)
                    .addHeader("token","344270641b9444bea7579495a6c2432d")
                    .method(reqMethod,null)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override public void onResponse(Call call, Response response) throws IOException {
                    try (ResponseBody responseBody = response.body()) {
                        callback.callBack(responseBody.string());
                    }
                }
            });
        }
}
