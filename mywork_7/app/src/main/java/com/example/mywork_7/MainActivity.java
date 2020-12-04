package com.example.mywork_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "线程通信";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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