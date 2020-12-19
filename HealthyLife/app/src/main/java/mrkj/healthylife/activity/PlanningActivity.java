package mrkj.healthylife.activity;

import android.app.DatePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.utils.Constant;
import mrkj.healthylife.utils.GetBMIValuesHelper;
import mrkj.healthylife.utils.SaveKeyValues;
import mrkj.library.wheelview.scalerulerview.ScaleRulerView;

/**
 * 制定计划-->设置相关信息
 */
public class PlanningActivity extends BaseActivity implements View.OnFocusChangeListener,View.OnClickListener{

    private static final int SET_START_DATE = 0;//设置开始时间
    private static final int SET_STOP_DATE = 1;//设置结束时间
    //功能
    private DatePickerDialog datePickerDialog;//创建时间选择器
    private GetBMIValuesHelper getBMIValuesHelper;//获取体指信息
    //控件
    private TextView setStartTime,setStopTime;//设置开始和结束的时间
    private TextView show_plan_weight;//显示期望体重
    private ScaleRulerView setPlanWeight;//设置目标体重
    private Button finish;//完成按钮
    private TextView capion;//标准体重范围提示
    private TextView hint;//提示
    //数值
    private boolean isSetStart;//区别设置
    private int nowYear;//当前年
    private int nowMonth;//当前月
    private int nowDate;//当前日
    private Double min_normal_weight;//标准体重的最小值
    private Double max_normal_weight;//标准体重的最大值
    private int now_weight;//当前体重
    private int start_year;//开始年
    private int start_month;//开始月
    private int start_date;//开始日
    private int stop_year;//结束年
    private int stop_month;//结束月
    private int stop_date;//结束日
    private int plan_want_weight;//目标体重


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    /**
     * 设置标题
     */
    @Override
    protected void setActivityTitle() {
        initTitle();//初始化标题
        setTitle(getString(R.string.target));//设置标题
        setTitleTextColor(getResources().getColor(R.color.black));//设置字体颜色
    }

    /**
     * 初始化布局文件
     */
    @Override
    protected void getLayoutToView() {
        setContentView(R.layout.activity_planning);
    }

    /**
     * 初始化相关变量
     */
    @Override
    protected void initValues() {
        //设置默认加载发现界面
        SaveKeyValues.putIntValues("launch_which_fragment", Constant.MAKE_PLAN);
        getNowDate();
        int height = SaveKeyValues.getIntValues("height",0);
        int weight = SaveKeyValues.getIntValues("weight",0);
        Log.e("身高体重值","身高："+height + "\t\t体重："+weight);
        getBMIValuesHelper = new GetBMIValuesHelper();
        Map<String,Double> map = getBMIValuesHelper.getNormalWeightRange(height);
        min_normal_weight = map.get("min");
        max_normal_weight = map.get("max");
        now_weight = weight;
    }

    /**
     * 获取当前日期
     */
    private void getNowDate(){
        Calendar calendar = Calendar.getInstance();
        nowYear = calendar.get(Calendar.YEAR);
        nowMonth = calendar.get(Calendar.MONTH);
        nowDate = calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {
        hint = (TextView) findViewById(R.id.change_txt);
        setStartTime = (TextView) findViewById(R.id.plan_start_time);
        setStopTime = (TextView) findViewById(R.id.plan_stop_time);
        setPlanWeight = (ScaleRulerView) findViewById(R.id.plan_input_weight);
        show_plan_weight = (TextView) findViewById(R.id.plan_show_weight);
        capion = (TextView) findViewById(R.id.show_normal_weight_range);
        finish = (Button) findViewById(R.id.finish);

    }

    /**
     * 设置标尺与TextView关联
     */
    private ScaleRulerView.OnValueChangeListener set_plan_weight_listener = new ScaleRulerView.OnValueChangeListener() {
        @Override
        public void onValueChange(float value) {
            show_plan_weight.setText((int)value + getString(R.string.kg));
            plan_want_weight = (int) value;
            if ((int)value != now_weight){
                hint.setText(getString(R.string.plan_weight));
            }
        }
    };

    /**
     * 设置监听
     */
    @Override
    protected void setViewsListener() {
        setStartTime.setOnFocusChangeListener(this);
        setStopTime.setOnFocusChangeListener(this);
        setStartTime.setOnClickListener(this);
        setStopTime.setOnClickListener(this);
        finish.setOnClickListener(this);
        setPlanWeight.setValueChangeListener(set_plan_weight_listener);
    }

    /**
     * 设置功能
     */
    @Override
    protected void setViewsFunction() {
        setStartTime.setClickable(true);
        setStartTime.setFocusableInTouchMode(true);
        setStopTime.setClickable(true);
        setStopTime.setFocusableInTouchMode(true);
        capion.setText(getString(R.string.normal_weight_range) + min_normal_weight + "~" + max_normal_weight + getString(R.string.kg));
        //目标体重选择
        setPlanWeight.initViewParam(now_weight, 130, 30);
        //创建时间选择器
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                if (isSetStart){//设置开始时间
                    start_year = year;
                    start_month = monthOfYear + 1;
                    start_date = dayOfMonth;
                    setStartTime.setText(year+getString(R.string.year)+(monthOfYear+1)+getString(R.string.month)+dayOfMonth+getString(R.string.day));
                }else {//设置结束时加
                    stop_year = year;
                    stop_month = monthOfYear + 1;
                    stop_date = dayOfMonth;
                    setStopTime.setText(year+getString(R.string.year)+(monthOfYear+1)+getString(R.string.month)+dayOfMonth+getString(R.string.day));
                }
            }
        },nowYear,nowMonth,nowDate);
    }

    /**
     * 获取焦点
     * @param v
     * @param hasFocus
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.plan_start_time://计划开始时间
                if (hasFocus){
                    isSetStart = true;
                    showDateDialog(SET_START_DATE);
                }
                break;
            case R.id.plan_stop_time://计划结束时间
                if (hasFocus){
                    isSetStart = false;
                    showDateDialog(SET_STOP_DATE);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 显示选择日期时间弹窗
     * @param type
     */
    private void showDateDialog(int type){

        if (type == SET_START_DATE){
            datePickerDialog.setTitle(getString(R.string.set_start_time));
            datePickerDialog.show();
        }else {
            datePickerDialog.setTitle(getString(R.string.set_stop_time));
            datePickerDialog.show();
        }
    }


}
