package mrkj.healthylife.activity;

import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.db.DatasDao;
import mrkj.healthylife.utils.SaveKeyValues;

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
        setContentView(R.layout.activity_sport_message);
    }

    @Override
    protected void initValues() {
        plans = SaveKeyValues.getIntValues("finish_plan" , 0);
        Log.e("plans",plans+"");
        datasDao = new DatasDao(this);
        cursor = datasDao.selectAll("step");
        day_values = 1 + cursor.getCount();
        double hot_values = 0;
        int step = 0;
        counts = cursor.getCount();
        list =new ArrayList<>();
        if ( counts> 0){
            while (cursor.moveToNext()){
                String hot = cursor.getString(cursor.getColumnIndex("hot"));
                int steps = cursor.getInt(cursor.getColumnIndex("steps"));
                double hots = Double.parseDouble(hot);
                hot_values += hots;
                step += steps;
                Map<String , Object> map = new HashMap<>();
                String date_data = cursor.getString(cursor.getColumnIndex("date"));
                int step_data = cursor.getInt(cursor.getColumnIndex("steps"));
                String length_data = cursor.getString(cursor.getColumnIndex("length"));
                String hot_data = cursor.getString(cursor.getColumnIndex("hot"));

                map.put("date" , date_data);
                map.put("step" , step_data);
                map.put("length" , length_data);
                map.put("hot" , hot_data);
                Log.e("ss", date_data + "==" + step_data + "=="+length_data+"=="+hot_data+ "==");
                list.add(map);
            }
        }
        hot_values = hot_values + Double.parseDouble(SaveKeyValues.getStringValues("sport_heat","0.00"));
        hot_str = formatDouble(hot_values);
        step = step + SaveKeyValues.getIntValues("sport_steps",0);
        scores = (int) (step * 0.5);
    }

    @Override
    protected void initViews() {
        finish_plans = (TextView) findViewById(R.id.left_txt);
        keepfit_scores = (TextView) findViewById(R.id.sport_scores);
        sport_days = (TextView) findViewById(R.id.center_txt);
        sport_hot = (TextView) findViewById(R.id.right_txt);


        all_lin = (LinearLayout) findViewById(R.id.all_data);
        all_btn = (Button) findViewById(R.id.data_all);
        day_lin = (RelativeLayout) findViewById(R.id.day_data);
        day_btn = (Button) findViewById(R.id.data_day);
        dataList = (ListView) findViewById(R.id.data_list);
    }

    /**
     * 计算并格式化doubles数值，保留两位有效数字
     *
     * @param doubles
     * @return 返回当前路程
     */
    private String formatDouble(Double doubles) {
        DecimalFormat format = new DecimalFormat("####.##");
        String distanceStr = format.format(doubles);
        return distanceStr.equals("0") ? "0.00" : distanceStr;
    }

    @Override
    protected void setViewsListener() {
        all_btn.setOnClickListener(this);
        day_btn.setOnClickListener(this);
    }

    @Override
    protected void setViewsFunction() {

    }
}
