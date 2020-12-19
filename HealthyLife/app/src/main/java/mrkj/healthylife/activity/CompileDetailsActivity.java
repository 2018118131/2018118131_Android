package mrkj.healthylife.activity;

import android.view.View;
import android.widget.TextView;

import java.io.File;

import mrkj.healthylife.base.BaseActivity;
import mrkj.library.wheelview.circleimageview.CircleImageView;

/**
 * 更改用户信息
 */
public class CompileDetailsActivity extends BaseActivity implements View.OnClickListener{

    private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_GALLERY2 = 4;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";// 图片名称

    //1、更换头像
    private CircleImageView head_image;//显示头像
    private TextView change_image;//更换头像
    private String path;//头像的路径
    private File tempFile;//图片路径

    @Override
    public void onClick(View view) {

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
