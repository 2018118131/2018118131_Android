package com.example.mywork_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button download;
    ProgressBar pb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class DownloadTask extends AsyncTask<Integer,Integer,String>{

        @Override
        protected String doInBackground(Integer... params){
            return null;
        }
    }

}