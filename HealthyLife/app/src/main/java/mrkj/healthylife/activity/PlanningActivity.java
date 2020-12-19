package mrkj.healthylife.activity;

import android.app.DatePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
