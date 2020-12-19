package mrkj.healthylife.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseFragment;
import mrkj.healthylife.entity.PMInfo;
import mrkj.healthylife.entity.TodayInfo;
import mrkj.healthylife.utils.Constant;
import mrkj.healthylife.utils.SaveKeyValues;
import mrkj.healthylife.utils.StepDetector;
import mrkj.library.wheelview.circlebar.CircleBar;

/**
 * 运动
 * 功能介绍显示所在城市的空气质量和温度
 * 展示走步的进度
 * 展示一走的里程和消耗的热量
 * 跳转界面的功能按钮
 */
public class SportFragment extends BaseFragment {//此处直接继承Fragment即可

    private static final int WEATHER_MESSAGE = 1;//显示天气信息
    private static final int STEP_PROGRESS = 2;//显示步数信息
    private View view;//界面的布局
    private TextView city_name, city_temperature, city_air_quality;//展示天气相关控件
    //显示精度的圆形进度条
    private CircleBar circleBar;//进度条
    private TextView show_mileage, show_heat, want_steps;//显示里程和热量
    private ImageButton warm_btn;//跳转按钮
    //下载天气预报的相关信息
    private TodayInfo todayInfo;//今日的天气
    private PMInfo pmInfo;//今日空气质量
    private String weather_url;//天气接口
    private String query_city_name;//城市名称
    //展示进度、里程、热量的相关参数
    private int custom_steps;//用户的步数
    private int custom_step_length;//用户的步长
    private int custom_weight;//用户的体重
    private Thread get_step_thread; // 定义线程对象
    private Intent step_service;//计步服务
    private boolean isStop;//是否运行子线程
    private Double distance_values;// 路程：米
    private int steps_values;//步数
    private Double heat_values;//热量
    private int duration;//动画时间
    private Context context;
    //传值
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case WEATHER_MESSAGE://天气信息网络请求结束后会跳到这里
                    String jsonStr = (String) msg.obj;
                    //获取Json数据
//                    Log.e("downLoad", "success:" + jsonStr);
                    if (jsonStr != null) {
                        //获取下载的Json数据并进行相应的设置
                        setDownLoadMessageToView(jsonStr);
                    }
                    break;
                case STEP_PROGRESS://步数跟新后会调至这里
                    //获取计步的步数
                    steps_values = StepDetector.CURRENT_SETP;
                    //吧步数的进度显示在进度条上
                    circleBar.update(steps_values, duration);
                    duration = 0;
                    //存储当前的步数
                    SaveKeyValues.putIntValues("sport_steps", steps_values);
//                    Log.e("执行了", ":" + steps_values);
                    //计算里程
                    distance_values = steps_values *
                            custom_step_length * 0.01 * 0.001;//km
//                    Log.e("里程", ":" + distance_values+"km");
                    show_mileage.setText(formatDouble(distance_values) + context.getString(R.string.km));
                    //存值
                    SaveKeyValues.putStringValues("sport_distance",
                            formatDouble(distance_values));
                    //消耗热量:跑步热量（kcal）＝体重（kg）×距离（公里）×1.036
                    heat_values = custom_weight * distance_values * 1.036;
                    //展示信息
                    show_heat.setText(formatDouble(heat_values) + context.getString(R.string.cal));
                    //存值
                    SaveKeyValues.putStringValues("sport_heat",
                            formatDouble(heat_values));
                    break;
            }
            return false;
        }
    });

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    /**
     * 创建视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sport, null);
        initView();//初始化控件
        initValues();//初始化数据
        setNature();//设置功能
        //提示
        if (StepDetector.CURRENT_SETP > custom_steps) {
            Toast.makeText(getContext(), "您已达到目标步数,请适量运动！"
                    , Toast.LENGTH_LONG).show();
        }
        //提示弹窗
        if (SaveKeyValues.getIntValues("do_hint", 0) == 1
                && (System.currentTimeMillis() > (SaveKeyValues.
                getLongValues("show_hint", 0) + Constant.DAY_FOR_24_HOURS))) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle("提示");
            alertDialog.setMessage("你有计划没有完成!");
            alertDialog.setPositiveButton("点击确定不再提示！",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SaveKeyValues.putIntValues("do_hint", 0);
                        }
                    });
            alertDialog.create();//创建弹窗
            alertDialog.show();//显示弹窗
        }
        return view;
    }

}
