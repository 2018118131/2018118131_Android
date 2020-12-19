package mrkj.healthylife.activity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.application.DemoApplication;
import mrkj.healthylife.db.DatasDao;
import mrkj.healthylife.utils.DateUtils;

/**
 * 添加计划的界面
 */
public class SettingHealthyHealthyActivity extends AppCompatActivity implements TimePicker.OnTimeChangedListener, View.OnClickListener {

    private TextView back;
    private TextView title;//运动类型
    private int type;
    private String title_name;
    private TimePicker timePicker;//设置时间
    private int alarmhour;//提示时
    private int alarmminute;//提示分
    private DatePickerDialog datePickerDialog;
    private Button start, stop;
    private int index;//用于区分获取开始还是结束
    private int start_year,start_month,start_day,stop_year,stop_month,stop_day;
    private Button finish_setting;
    //存入数据
    private DatasDao datasDao;
    private boolean isToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_healthy_healthy);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);// 设置布局填充activity界面

        datasDao = new DatasDao(this);
        Intent intent = getIntent();

        //返回
        back = (TextView) findViewById(R.id.to_back);
        back.setOnClickListener(this);
        //类型
        title = (TextView) findViewById(R.id.plan_type);
        type = intent.getIntExtra("type", 0);
        title_name = DemoApplication.shuoming[type];
        title.setText(title_name);
        //时间
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        timePicker.setOnTimeChangedListener(this);
        //日期
        Map<String, Object> timeMap = DateUtils.getDate();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                switch (index){
                    case 0://start
                        start_year = year;
                        start_month = monthOfYear + 1;
                        start_day = dayOfMonth;
                        start.setText("起始："+start_year + "-" + start_month + "-" + start_day);
                        break;
                    case 1://stop
                        stop_year = year;
                        stop_month = monthOfYear + 1;
                        stop_day = dayOfMonth;
                        stop.setText("结束："+stop_year + "-" + stop_month + "-" + stop_day);
                        break;
                    default:
                        break;

                }
            }
        }, (Integer) timeMap.get("year"), (Integer) timeMap.get("month") - 1, (Integer) timeMap.get("day"));
        start = (Button) findViewById(R.id.plan_start);
        stop = (Button) findViewById(R.id.plan_stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        //完成
        finish_setting = (Button) findViewById(R.id.set_clock);
        finish_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 时间改变回调
     *
     * @param view
     * @param hourOfDay
     * @param minute
     */
    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//        Log.e("hourOfDay",hourOfDay + "时");
//        Log.e("minute", minute + " 分");
        alarmhour = hourOfDay;
        alarmminute = minute;
    }

    private void insertData(ContentValues values){
        if (isToSave){
            //向数据库中插入数据
            long result = datasDao.insertValue("plans",values);
            if (result > 0){
                Toast.makeText(this,"设置计划成功！",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }else {
                Toast.makeText(this,"设置计划失败！请重新设置计划！",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
