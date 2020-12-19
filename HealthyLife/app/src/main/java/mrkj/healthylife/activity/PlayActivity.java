package mrkj.healthylife.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;

public class PlayActivity extends BaseActivity implements View.OnClickListener{

    private int index;
    private int what;
    private boolean isNext;
    private boolean isOff;//-->默认为false
    private TextView play_time;
    private TextView play_name;
    private TextView play_message;
    private boolean isChange;
    private TextView play_more;
    private TextView play_back;
    private ImageView imageView;
    private ImageView play_switch,play_next;//播放开关
    private AnimationDrawable animationDrawable;
    private static final String zeroStr = "00:00";
    private Button back_sport;
    private LinearLayout one,two;
    private int doplan;
    private boolean isClose;//-->计时
    private Thread thread;
    private int values;
    private ProgressBar progressBar;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what){
                case 1:
                    int values1 = (int) msg.obj;
                    if (isNext){
                        return false;
                    }
                    if (values1 == 11){
                        handler.removeMessages(1);
                        animationDrawable.stop();
                        isOff = false;
                        isClose = true;
                    }
                    progressBar.setProgress(values);
                    if (values1 < 10){
                        play_time.setText("00:0"+values);
                    }else {
                        play_time.setText("00:" + values);
                    }
                    if (values1 == 12){
                        play_switch.setImageResource(R.mipmap.mrkj_play_start);
                        Toast.makeText(PlayActivity.this, "运动结束", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
            return false;
        }
    });
    private int[] frameRes = new int[]{R.drawable.donghua1,
            R.drawable.donghua2,
            R.drawable.donghua3,
            R.drawable.donghua4,
            R.drawable.donghua5};


    @Override
    public void onClick(View view) {

    }

    @Override
    protected void setActivityTitle() {
        initTitle();
        setTitle("运动", this);
        setMyBackGround(R.color.watm_background_gray);
        setTitleTextColor(R.color.theme_blue_two);
        setTitleLeftImage(R.mipmap.mrkj_back_blue);
    }

    @Override
    protected void getLayoutToView() {
        setContentView(R.layout.activity_play);
    }

    @Override
    protected void initValues() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void setViewsListener() {

    }

    @Override
    protected void setViewsFunction() {

    }
}
