package com.example.mywork_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                ProgressDialog progressDialog = new ProgressDialog(SecondActivity.this);
                progressDialog.setTitle("即将展现体重数据");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}