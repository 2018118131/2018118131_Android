package com.example.mywork_9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
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
        return super.onStartCommand(intent, flags, startId);
    }


}
