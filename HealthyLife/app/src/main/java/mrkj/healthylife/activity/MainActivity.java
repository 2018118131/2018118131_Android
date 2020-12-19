package mrkj.healthylife.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

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
