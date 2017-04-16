package com.example.bruse.phpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruse.phpdemo.util.GetPostUtil;

public class MainActivity extends AppCompatActivity {
    Button get, post;
    TextView show;
    // 代表服务器响应的字符串
    String response;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                // 设置show组件显示服务器响应
                show.setText(response);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get = (Button) findViewById(R.id.get);
        post = (Button) findViewById(R.id.post);
        show = (TextView) findViewById(R.id.show);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        response = GetPostUtil.sendGet(
                                "http://192.168.191.3/studentproject/index.php"
                                , null);
                        // 发送消息通知UI线程更新UI组件
                        handler.sendEmptyMessage(0x123);
                    }
                }.start();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        response = GetPostUtil.sendPost(
                                "http://192.168.191.3/studentproject/home.php"
                                , "name=帅&pass=leegang");
                    }
                }.start();
                // 发送消息通知UI线程更新UI组件
                handler.sendEmptyMessage(0x123);
            }
        });
    }

}
