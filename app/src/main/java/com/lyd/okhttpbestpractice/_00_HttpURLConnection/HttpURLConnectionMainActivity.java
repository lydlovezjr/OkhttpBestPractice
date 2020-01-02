package com.lyd.okhttpbestpractice._00_HttpURLConnection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lyd.okhttpbestpractice.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 描述: HttpURLConnection使用
 * 作者: LYD
 * 创建日期: 2020/1/2 15:32
 */
public class HttpURLConnectionMainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btGet;
    private Button btPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_urlconnection_main);
        initView();
    }

    private void initView() {
        btGet = findViewById(R.id.bt_get);
        btPost = findViewById(R.id.bt_post);
        btGet.setOnClickListener(this);
        btPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_get:
                startActivity(new Intent(this, HttpURLConnectionGetActivity.class));
                break;
            case R.id.bt_post:
                break;
        }
    }
}
