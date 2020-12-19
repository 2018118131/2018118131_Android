package mrkj.healthylife.activity;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;
import mrkj.library.wheelview.pickerView.PickerView;
import mrkj.library.wheelview.scalerulerview.ScaleRulerView;
import mrkj.library.wheelview.utils.DateViewHelper;

/**
 * 完善信息界面
 * -->主界面是FunctionActivity
 */
public class MainActivity extends BaseActivity implements View.OnClickListener,PickerView.onSelectListener,RadioGroup.OnCheckedChangeListener,DateViewHelper.OnResultMessageListener,View.OnFocusChangeListener{

    //TAG
    private static final String TAG = MainActivity.class.getSimpleName();
    //功能
    private DateViewHelper dateViewHelper;//日历操作
    private LayoutInflater inflater;//布局填充器
    private boolean closeDataPicker;//判断显示或隐藏日历
    private List<String> height_list;//身高的集合
    private boolean closeHeightPicker;//判断显示或隐藏数字选择器
    private boolean nextShow;//判断按钮是否显示
    //控件
    private LinearLayout personal_information_page_one;//完善资料1/2布局
    private RadioGroup group;//性别选择
    private EditText input_nick;//属性昵称
    private TextView input_birthday,input_height;//生日、身高
    private Button next_action;//下一步
    private LinearLayout choose_date;//日期选择
    private LinearLayout choose_height;//选择身高
    private PickerView height_picker;//横下滑动选择身高
    private ImageView back;//返回上一步
    private LinearLayout personal_information_page_two;//完善资料2/2布局
    private ScaleRulerView input_weight;//选择体重
    private TextView show_weight;//显示选择的体重
    private ScaleRulerView input_length;//选择体重
    private TextView show_length;//显示选择的体重
    private Button go_walk;//先去逛逛
    private Button go_make;//制定计划
    //信息
    private String gender_str;//性别
    private String nick_str;//昵称
    private String birthday_str;//生日
    private String height_str;//身高
    private int custom_age;//年龄
    private String weight_str;//体重文字
    private int weight;//体重数值
    private String length_str;//步长文字
    private int length;//步长数值

    private int year;
    private int month;
    private  int day;

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }

    @Override
    public void onSelect(String s) {

    }

    @Override
    public void getMessage(Map<String, Object> map) {

    }

    /**
     * 初始化标题
     */
    @Override
    protected  void setActivityTitle(){
        initTitle();
        setTitle(getString(R.string.personal_information_one));
        setTitleTextColor(getResources().getColor(R.color.black));


    }

    /**
     * 初始化窗口
     */
    @Override
    protected void getLayoutToView() {
        setContentView(R.layout.activity_main);}

    /**
     * 设置初始化的值和变量
     */
    @Override
    protected void initValues() {
        gender_str = getResources().getString(R.string.boy);
        initHeightData();
        nextShow = true;
    }

    /**
     * 初始化身高的集合
     */
    private void initHeightData(){
        //设置130cm至210cm
        height_list = new ArrayList<>();
        for (int i = 130;i <= 210;i++){
            height_list.add(i+"");
        }
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {

        //======================================= 完善资料1/2 =======================================

        personal_information_page_one = (LinearLayout) findViewById(R.id.personal_information_page_one);
        group = (RadioGroup) findViewById(R.id.gender);
        input_nick = (EditText) findViewById(R.id.input_nick);
        input_birthday = (TextView) findViewById(R.id.input_birthday);
        input_height = (TextView) findViewById(R.id.input_height);
        next_action = (Button) findViewById(R.id.next);
        //设置日期选择器
        inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        choose_date=(LinearLayout) findViewById(R.id.choose_date);
        dateViewHelper = new DateViewHelper(this);
        //设置身高选择器
        choose_height = (LinearLayout) findViewById(R.id.choose_height);
        height_picker = (PickerView) findViewById(R.id.height_picker);


        //======================================= 完善资料2/2 =======================================

        personal_information_page_two = (LinearLayout) findViewById(R.id.personal_information_page_two);
        input_weight = (ScaleRulerView) findViewById(R.id.input_weight);
        show_weight = (TextView) findViewById(R.id.show_weight);
        input_length = (ScaleRulerView) findViewById(R.id.input_length);
        show_length = (TextView) findViewById(R.id.show_length);
        go_walk = (Button) findViewById(R.id.walk);
        go_make = (Button) findViewById(R.id.make);
    }

    /**
     * 获取体重信息
     */
    private ScaleRulerView.OnValueChangeListener input_weight_listener = new ScaleRulerView.OnValueChangeListener() {
        @Override
        public void onValueChange(float value) {
            show_weight.setText((int)value+getString(R.string.kg));
            weight = (int) value;
            weight_str = (int)value+getString(R.string.kg);
        }
    };
    /**
     * 获取步长信息
     */
    private ScaleRulerView.OnValueChangeListener input_length_listener = new ScaleRulerView.OnValueChangeListener() {
        @Override
        public void onValueChange(float value) {
            show_length.setText((int)value+getString(R.string.cm));
            length = (int) value;
            length_str = (int)value+getString(R.string.cm);
        }
    };

    /**
     * 用于隐藏设置器和键盘
     */
    private View.OnTouchListener messageListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP){
                hideOthers();
            }
            return true;
        }
    };

    /**
     * 初始化控件的监听
     */
    @Override
    protected void setViewsListener() {

        //======================================= 完善资料1/2 =======================================

        group.setOnCheckedChangeListener(this);
        input_birthday.setOnClickListener(this);
        input_height.setOnClickListener(this);
        next_action.setOnClickListener(this);
        dateViewHelper.setOnResultMessageListener(this);
        input_nick.setOnFocusChangeListener(this);
        input_birthday.setOnFocusChangeListener(this);
        input_height.setOnFocusChangeListener(this);
        height_picker.setOnSelectListener(this);
        personal_information_page_one.setOnTouchListener(messageListener);

        //======================================= 完善资料2/2 =======================================

        input_weight.setValueChangeListener(input_weight_listener);
        input_length.setValueChangeListener(input_length_listener);
        go_walk.setOnClickListener(this);
        go_make.setOnClickListener(this);
    }

    /**
     * 设置相关管功能
     */
    @Override
    protected void setViewsFunction() {

        //======================================= 完善资料1/2 =======================================

        personal_information_page_one.setVisibility(View.VISIBLE);
        input_nick.setClickable(true);
        input_birthday.setClickable(true);
        input_height.setClickable(true);
        input_nick.setFocusableInTouchMode(true);
        input_birthday.setFocusableInTouchMode(true);
        input_height.setFocusableInTouchMode(true);
        //设置日期选择器
        choose_date.addView(dateViewHelper.getDataPick(inflater));
        //设置身高选择器
        height_picker.setData(height_list);

        //======================================= 完善资料2/2 =======================================

        personal_information_page_two.setVisibility(View.GONE);
        //默认50千克，最小30千克，最大130千克-->单位千克
        input_weight.initViewParam(50, 130, 30);
        //默认70厘米，最小40厘米，最大100厘米-->单位厘米
        input_length.initViewParam(70, 100, 40);
    }

    /**
     * 单选
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        hideOthers();
        //选择性别
        switch (checkedId){
            case R.id.boy://男
                gender_str = getResources().getString(R.string.boy);
                break;
            case R.id.girl://女
                gender_str = getResources().getString(R.string.girl);
                break;
            default:
                break;
        }
    }

}
