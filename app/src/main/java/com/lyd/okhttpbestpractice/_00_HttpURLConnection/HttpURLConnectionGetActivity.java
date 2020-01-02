package com.lyd.okhttpbestpractice._00_HttpURLConnection;

import android.os.Bundle;
import android.util.Log;

import com.lyd.okhttpbestpractice.R;
import com.lyd.okhttpbestpractice.utils.StreamUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 描述:  基于HttpURLConnection的Get请求
 * 作者: LYD
 * 创建日期: 2020/1/2 15:37
 */
public class HttpURLConnectionGetActivity extends AppCompatActivity {
    private static final String TAG = "HttpURLConnectionGetActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_urlconnection_get_activity);
        String url = "https://suggest.taobao.com/sug";
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("code", "utf-8");
        paramsMap.put("q", "卫衣");
        paramsMap.put("callback", "cb");
        getUse(url, paramsMap);
    }

    private void getUse(final String baseUrl, final HashMap<String, String> paramsMap) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //合成请求参数
                    StringBuilder tempParams = new StringBuilder();
                    int pos = 0;
                    for (String key : paramsMap.keySet()) {
                        if (pos > 0) {
                            tempParams.append("&");
                        }
                        tempParams.append(String.format("%s=%s", key, URLEncoder.encode(paramsMap.get(key), "utf-8")));
                        pos++;
                    }
                    String requestUrl = baseUrl + tempParams.toString();
                    //创建Url对象
                    URL url = new URL(requestUrl);
                    //得到connection对象
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //设置请求方式
                    connection.setRequestMethod("GET");
                    //设置连接主机超时时间
                    connection.setConnectTimeout(10 * 1000);
                    //设置从主机读取数据超时时间
                    connection.setReadTimeout(10 * 1000);
                    //设置是否使用缓存默认是true
                    connection.setUseCaches(true);
                    //连接
                    connection.connect();
                    //得到响应码
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        //得到响应流
                        InputStream inputStream = connection.getInputStream();
                        //响应流转成字符串
                        String result = StreamUtil.streamToStr(inputStream);
                        Log.e(TAG, "Get方式请求成功result--->" + result);
                    }
                    //关闭连接
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
