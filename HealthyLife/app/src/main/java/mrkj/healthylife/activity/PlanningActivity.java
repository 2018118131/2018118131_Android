package mrkj.healthylife.activity;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.utils.GetBMIValuesHelper;
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

    @Override
    protected void setActivityTitle() {

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
