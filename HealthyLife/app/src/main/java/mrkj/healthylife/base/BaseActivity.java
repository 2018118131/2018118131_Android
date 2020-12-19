package mrkj.healthylife.base;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mrkj.healthylife.R;


public abstract class BaseActivity extends AppCompatActivity{
    private TextView title_center;//标题的中间部分
    private ImageView title_left,title_right;//标题的左边和右边
    private RelativeLayout title_relRelativeLayout;

    /**
     * 初始化标题
     */
    public void initTitle(){
        title_center = (TextView) findViewById(R.id.titles);
        title_left = (ImageView) findViewById(R.id.left_btn);
        title_right = (ImageView) findViewById(R.id.right_btn);
        title_left.setVisibility(View.INVISIBLE);
        title_right.setVisibility(View.INVISIBLE);
        title_relRelativeLayout = (RelativeLayout) findViewById(R.id.title_back);
    }

    public void setMyBackGround(int color){
        title_relRelativeLayout.setBackgroundResource(color);
    }

    /**
     * 设置TextView的下滑线
     * @param view
     */
    public void setTextViewUnderLine(TextView view){
        Paint paint = view.getPaint();
        paint.setColor(getResources().getColor(R.color.btn_gray));//设置画笔颜色
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setFlags(Paint.UNDERLINE_TEXT_FLAG);//设置下滑线
        view.invalidate();
    }
    /**
     * 初始化标题
     */
    protected abstract void setActivityTitle();
    /**
     * 初始化窗口
     */
    protected abstract void getLayoutToView();
    /**
     * 设置初始化的值和变量
     */
    protected abstract void initValues();
    /**
     * 初始化控件
     */
    protected abstract void initViews();

}
