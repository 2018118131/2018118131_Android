package mrkj.healthylife.activity;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.db.DatasDao;

public class SportMessageActivity extends BaseActivity implements View.OnClickListener{

    private TextView finish_plans;
    private TextView sport_days;
    private TextView sport_hot;
    private TextView keepfit_scores;
    private int plans;
    private String hot_str;
    private int day_values;
    private int scores;
    private DatasDao datasDao;
    private Button all_btn,day_btn;
    private LinearLayout all_lin;
    private RelativeLayout day_lin;
    private Cursor cursor;
    private ListView dataList;
    private int counts;
    private List<Map<String , Object>> list;


    @Override
    public void onClick(View view) {

    }

    @Override
    protected void setActivityTitle() {
        initTitle();
        setTitle("运动记录", this);
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
