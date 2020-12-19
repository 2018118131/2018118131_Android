package mrkj.healthylife.activity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;

public class WarmUpActivity extends BaseActivity {

    private int what;
    private ImageView imageView;
    private TextView type,count,time;
    private Button start;
    @Override
    protected void setActivityTitle() {
        initTitle();
        setTitle("推荐热身", this);
        setMyBackGround(R.color.watm_background_gray);
        setTitleTextColor(R.color.theme_blue_two);
        setTitleLeftImage(R.mipmap.mrkj_back_blue);
    }

    @Override
    protected void getLayoutToView() {

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
