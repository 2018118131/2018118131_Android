package mrkj.healthylife.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import mrkj.healthylife.db.DatasDao;

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
    public void onClick(View view) {

    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

    }
}
