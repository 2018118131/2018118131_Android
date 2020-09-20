package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

protected void onStart(){
        super.onStart();
}

protected void onResume(){
        super.onResume();
}

protected void onPause(){
        super.onPause();
}

protected void onStop(){
        super.onStop();
}

protected void onDestroy(){
        super.onDestroy();
}

protected void onRestart(){
        super.onRestart();
}


}