package mrkj.healthylife.activity;

import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.fragment.FindFragment;
import mrkj.healthylife.fragment.HeartFragment;
import mrkj.healthylife.fragment.MineFragment;
import mrkj.healthylife.fragment.SportFragment;

/**
 * 功能界面
 */
public class FunctionActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{


    //变量
    private long exitTime;//第一次单机退出键的时间
    private int load_values;//判断加载fragment的变量
    //控件
    private RadioGroup radioGroup;//切换按钮的容器
    private RadioButton sport_btn,find_btn,heart_btn,mine_btn;//切换按钮
    //碎片
    private SportFragment sportFragment;//运动
    private FindFragment findFragment;//发现
    private HeartFragment heartFragment;//心率
    private MineFragment mineFragment;//我的

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

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

    /**
     * 按两次退出按钮退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            // System.currentTimeMillis()无论何时调用，肯定大于2000
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
