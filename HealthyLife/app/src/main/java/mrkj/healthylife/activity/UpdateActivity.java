package mrkj.healthylife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.db.DatasDao;
import mrkj.healthylife.utils.DateUtils;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener,TimePicker.OnTimeChangedListener{


    private Button change_stop_date,dimind_change_date;
    private TextView back_to_front;
    private TimePicker change_time;
    private int hour,minute;
    private int change_year,change_month,change_day;
    private int index;
    private int id;
    private DatasDao datasDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent = getIntent();
        index = intent.getIntExtra("position",0);
        id = intent.getIntExtra("id",1);
        Map<String,Object> time = DateUtils.getDate();
        change_year = (int) time.get("year");
        change_month = (int) time.get("month");
        change_day = (int) time.get("day");
        hour = (int) time.get("hour");
        minute = (int) time.get("minute");
        datasDao = new DatasDao(this);
        //初始化控件
        change_stop_date = (Button) findViewById(R.id.plan_stop);
        dimind_change_date = (Button) findViewById(R.id.set_clock);
        back_to_front = (TextView) findViewById(R.id.to_back);
        change_time = (TimePicker) findViewById(R.id.timePicker1);
        //设置监听事件
        change_stop_date.setOnClickListener(this);
        dimind_change_date.setOnClickListener(this);
        back_to_front.setOnClickListener(this);
        change_time.setOnTimeChangedListener(this);

        dimind_change_date.setText("确定更改第【"+(++index)+"】条计划吗？");
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

    }
}
