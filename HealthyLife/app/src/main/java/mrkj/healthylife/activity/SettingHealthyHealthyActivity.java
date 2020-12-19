package mrkj.healthylife.activity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import mrkj.healthylife.db.DatasDao;

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
    public void onClick(View view) {

    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

    }
}
