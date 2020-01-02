package com.lyd.okhttpbestpractice.use;

import android.os.Bundle;
import android.util.Log;

import com.lyd.okhttpbestpractice.R;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 描述: 基础使用
 * 作者: LYD
 * 创建日期: 2019/12/27 17:18
 */
public class BasicUseActivity extends AppCompatActivity {
    private static final String TAG = "BasicUseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_use);
        getUse();
    }


    /**
     *
     */
    private void getUse() {
        try {
            //构建客户端
            OkHttpClient client = new OkHttpClient();
            //请求地址
            String getUrl = "https://raw.github.com/square/okhttp/master/README.md";
            //构建请求
            Request request = new Request
                    .Builder()
                    .url(getUrl)
                    .build();
            //发送请求
            Response response = client.newCall(request).execute();
            boolean isSuccess = response.isSuccessful();
            if (isSuccess) {
                String data = response.body().toString();
                Log.e(TAG, "相应数据:" + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
