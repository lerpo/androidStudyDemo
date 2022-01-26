package com.example.androiddemo.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetWorkUtils {
    private URL url;
    private HttpURLConnection connection;
    private static NetWorkUtils instance;
    private NetWorkUtils(){}
    public static synchronized NetWorkUtils getInstance() {
        if(instance == null) {
            instance = new NetWorkUtils();
        }
        return instance;
    }

    public void getRequest(String reqUrl, String reqMethod, NetCallback callback){
        try {
            // 先new出一个URL对象，传入网络地址
            // 调用openConnection()方法获取到HttpURLConnection对象
            url = new URL(reqUrl);
            connection = (HttpURLConnection) url.openConnection();
            // 设置HTTP请求所使用的方法，GET或者POST
            // GET表示从服务器获取数据
            // POST表示向服务器提交数据
            connection.setRequestMethod(reqMethod);
            // 下面使一些自由的定制，比如设置连接超时，读取超时的毫秒数，以及服务器希望得到的一些消息头
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            // 接下来利用输入流对数据进行读取
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
             callback.callBack(line);
            //最后关闭HTTP连接
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
