package mrkj.healthylife.fragment;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.view.LineChartView;
import mrkj.healthylife.base.BaseFragment;
import mrkj.healthylife.db.DatasDao;
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

    @Override
    public void onClick(View view) {

    }
}
