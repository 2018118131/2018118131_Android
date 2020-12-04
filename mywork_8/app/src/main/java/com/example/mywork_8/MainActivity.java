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

        public void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... params){
            for(int i = 0;i<=100;i++){
                pb.setProgress(i);
                publishProgress(i);
                try{
                    Thread.sleep(params[0]);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "执行完毕";
        }

        protected void onProgressUpdate(Integer... progress){
            tv.setText(progress[0]+"%");
            super.onProgressUpdate(progress);
        }

        protected void onPostExecute(String result){
            setTitle(result);
            super.onPostExecute(result);
        }
    }

}