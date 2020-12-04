package com.example.mywork_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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
        pb = (ProgressBar)findViewById(R.id.pb);
        tv = (TextView)findViewById(R.id.tv);

        download = (Button)findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DownloadTask dTask = new DownloadTask();
                dTask.execute(100);
            }
        });
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