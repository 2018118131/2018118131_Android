package mrkj.healthylife.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * 启动页
 */
public class LaunchActivity extends AppCompatActivity {
    private boolean isFirst;//是否为第一次启动
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                if (isFirst){
                    startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                }else {
                    startActivity(new Intent(LaunchActivity.this, FunctionActivity.class));
                }
                finish();
            }
            return false;
        }
    });
}
