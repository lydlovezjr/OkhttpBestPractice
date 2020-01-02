package com.lyd.okhttpbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lyd.okhttpbestpractice._00_HttpURLConnection.HttpURLConnectionMainActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btHttpUrlConnection;
    private Button btOkhttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btHttpUrlConnection = findViewById(R.id.bt_http_url_connection);
        btOkhttp = findViewById(R.id.bt_okhttp);
        btHttpUrlConnection.setOnClickListener(this);
        btOkhttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_http_url_connection:
                startActivity(new Intent(this, HttpURLConnectionMainActivity.class));
                break;
            case R.id.bt_okhttp:
                break;
        }
    }
}
