package mrkj.healthylife.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.view.LineChartView;
import mrkj.healthylife.R;
import mrkj.healthylife.activity.AboutActivity;
import mrkj.healthylife.activity.CompileDetailsActivity;
import mrkj.healthylife.activity.FoodHotListActivity;
import mrkj.healthylife.activity.MinePlanActivity;
import mrkj.healthylife.activity.SportMessageActivity;
import mrkj.healthylife.base.BaseFragment;
import mrkj.healthylife.db.DatasDao;
import mrkj.healthylife.utils.SaveKeyValues;
import mrkj.library.wheelview.circleimageview.CircleImageView;

/**
 * 我的界面
 *
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    private static final int CHANGE = 200;
    private View view;//界面的布局
    private Context context;
    //上半部分
    private CircleImageView head_image;//显示头像
    private ImageButton change_values;//更改信息按钮
    private TextView custom_name;//用户名称
    private TextView want;
    //中间部分
    private LineChartView lineChartView;//统计图
    private LineChartData data;//数据集
    private float[] points = new float[7];//折线点的数组
    private DatasDao datasDao;//读取数据工具
    private TextView show_steps;//显示今日已走的步数
    //下部分
    private TextView food;//食物热量对照表
    private EditText steps;//步数
    private TextView about;//关于我们
    private TextView sport_message;//运动信息
    private TextView plan_btn;//计划
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, null);
        //1、第一部分显示头像、昵称
        head_image = (CircleImageView) view.findViewById(R.id.head_pic);
        custom_name = (TextView) view.findViewById(R.id.show_name);
        change_values = (ImageButton) view.findViewById(R.id.change_person_values);
        //点击跳转到编辑个人信息界面
        change_values.setOnClickListener(this);
        //2、第二部分显示当日的步数和历史统计图
        show_steps = (TextView) view.findViewById(R.id.show_steps);
        lineChartView = (LineChartView) view.findViewById(R.id.step_chart);
        if (isAdded()) {
            datasDao = new DatasDao(getContext());
        }
        //显示信息
        showMessage();
        //3.初始化其余相关控件并添加点击事件的监听
        food = (TextView) view.findViewById(R.id.food_hot);
        food.setOnClickListener(this);
        want = (TextView) view.findViewById(R.id.want);
        want.setText("在" + SaveKeyValues.getStringValues("plan_stop_date","2016年6月16日")+"体重达到【"+SaveKeyValues.getIntValues("weight",50)+"】公斤");
        about = (TextView) view.findViewById(R.id.about_btn);
        about.setOnClickListener(this);
        sport_message = (TextView) view.findViewById(R.id.sport_btn);
        sport_message.setOnClickListener(this);
        steps = (EditText) view.findViewById(R.id.change_step);
        steps.setText(SaveKeyValues.getIntValues("step_plan" , 6000) + "");
        plan_btn = (TextView) view.findViewById(R.id.plan_btn);
        plan_btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!"".equals(steps.getText().toString())){
            SaveKeyValues.putIntValues("step_plan",Integer.parseInt(steps.getText().toString()));
        }else {
            SaveKeyValues.putIntValues("step_plan",6000);
        }
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_person_values:
                startActivityForResult(new Intent(context, CompileDetailsActivity.class), CHANGE);
                Toast.makeText(context, "跳转到编辑个人信息界面！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_btn:
                startActivity(new Intent(context, AboutActivity.class));
                break;
            case R.id.sport_btn:
                startActivity(new Intent(context, SportMessageActivity.class));
                break;
            case R.id.plan_btn:
                startActivity(new Intent(context, MinePlanActivity.class));
                break;
            case R.id.food_hot:
                startActivity(new Intent(context, FoodHotListActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * 显示上部分和显示下部分
     */
    public void showMessage() {
        //上
        String name = SaveKeyValues.getStringValues("nick", "未填写");//获取名称
        String image_path = SaveKeyValues.getStringValues("path", "path");//获取图片路径
        //设置显示和功能
        custom_name.setText(name);
        if (!"path".equals(image_path)) {
            Bitmap bitmap = BitmapFactory.decodeFile(image_path);
            head_image.setImageBitmap(bitmap);
        }
        //中
        int today_steps = SaveKeyValues.getIntValues("sport_steps", 0);
        show_steps.setText(today_steps + "步");
        //设置图表
        //获取保存的数据
        Cursor cursor = datasDao.selectAll("step");
        int counts = cursor.getCount();
        getDataValues(counts);
    }

}
