package mrkj.healthylife.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;
import mrkj.library.wheelview.circlebar.ColorArcProgressBar;

public class ShowBPMActivity extends BaseActivity {

    private TextView one,two,three;
    private ImageView share;//分享
    private ColorArcProgressBar bpm_show;//显示心率
    private int bpm_values;//心率值


    @Override
    protected void setActivityTitle() {
        initTitle();
        setMyBackGround(R.color.watm_background_gray);
        share = setTitle("心率测试结果", this, R.mipmap.mrkj_share_blue);
        setTitleLeftImage(R.mipmap.mrkj_back_blue);
        setTitleTextColor(R.color.theme_blue_two);
        share.setVisibility(View.INVISIBLE);
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
