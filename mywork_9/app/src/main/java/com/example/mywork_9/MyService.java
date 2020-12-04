package com.example.mywork_9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private MainActivity.Thread thread;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate(){
        super.onCreate();
        Log.d("MyService","执行OnCreate()方法");
    }

    public int onStartCommand(Intent intent,int flags,int startId) {
        Log.d("MyService", "执行OnStartCommand()方法");
        new Thread(new Runnable(){
            @Override
            public void run() {
                thread = new MainActivity.Thread();
                thread.execute();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy(){
        Log.d("MyService","执行OnDestroy()方法");
        super.onDestroy();
    }

}
