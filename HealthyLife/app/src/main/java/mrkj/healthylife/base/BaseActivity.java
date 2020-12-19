package mrkj.healthylife.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public abstract class BaseActivity extends AppCompatActivity{
    private TextView title_center;//标题的中间部分
    private ImageView title_left,title_right;//标题的左边和右边
    private RelativeLayout title_relRelativeLayout;

}
