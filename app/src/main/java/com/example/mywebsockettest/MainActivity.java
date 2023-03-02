package com.example.mywebsockettest;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private static final String TARGET = "ws://192.168.31.20:11111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        // 用目标地址初始化客户端
        MyWebSocketClient webSocketClient = null;
        try {
            webSocketClient = new MyWebSocketClient(new URI(TARGET));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if (webSocketClient == null) {
            return;
        }

        // 建立链接
        MyWebSocketClient finalWebSocketClient = webSocketClient;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    finalWebSocketClient.connectBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 发送消息
                finalWebSocketClient.send("{msg:hello}");
            }
        });
    }
}