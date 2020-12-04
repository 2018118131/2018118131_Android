package com.example.mywork_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SonThread sonThread = null;//子线程
    private static final String TAG = "线程通信";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sonThread = new SonThread();
        sonThread.start();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                threadExchangeData(sonThread.sonHandler);
            }
        });
    }

    private void threadExchangeData(Handler handler){
        Message msg = Message.obtain();
        String currThreadName = Thread.currentThread().getName();
        int data = new Random().nextInt();
        msg.obj = data;
        Log.d(TAG,"["+currThreadName+"] 发出随机数" +data);
        handler.sendMessage(msg);
    }

    private Handler mianHandler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            int data = (int)msg.obj;
            String threadName = Thread.currentThread().getName();
            Log.d(TAG,"["+threadName+"]收到随机数：" +data);
        }
    };

    private final class SonThread extends Thread{
        private Handler sonHandler = null;

        public void run(){
            super.run();
            Looper.prepare();
            sonHandler = new Handler(){
                public void handleMessage(Message msg){
                    super.handleMessage(msg);
                    int data = (int)msg.obj;
                    String threadName = Thread.currentThread().getName();
                    Log.d(TAG,"["+threadName+"]收到随机数"+data);
                    threadExchangeData(mianHandler);
                }
            };
            Looper.loop();
        }
    }


}