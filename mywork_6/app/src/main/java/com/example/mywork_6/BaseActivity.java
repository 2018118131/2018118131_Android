package com.example.mywork_6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
