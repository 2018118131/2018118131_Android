package mrkj.healthylife.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.File;
import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.utils.DateUtils;
import mrkj.healthylife.utils.SaveKeyValues;
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

    //2、修改昵称
    private String nick_str;//用户昵称
    private EditText change_nick;//修改昵称
    //3、修改性别
    private RadioGroup change_gender;//更改性别
    private String sex_str;//性别
    //4、修改生日
    private TextView change_birthDay;//更改
    private String date;
    //生日日期
    private int birth_year;
    private int birth_month;
    private int birth_day;
    //当日日期
    private int now_year;
    private int now_month;
    private int now_day;
    //5、修改身高
    private EditText change_height;
    private int height;
    //6、修改体重
    private EditText change_weight;
    private int weight;
    //7、修改步长
    private EditText change_length;
    private int length;
    //用户年龄
    //确定修改
    private Button change_OK_With_Save;//确定保存

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
        path = SaveKeyValues.getStringValues("path","path");
        nick_str = SaveKeyValues.getStringValues("nick","未填写");
        sex_str = SaveKeyValues.getStringValues("gender","男");
        //获取今日日期
        getTodayDate();
        birth_year = SaveKeyValues.getIntValues("birth_year",now_year);
        birth_month = SaveKeyValues.getIntValues("birth_month",now_month);
        birth_day = SaveKeyValues.getIntValues("birth_day",now_day);
        date = birth_year+"-"+birth_month+"-"+birth_day;

        height = SaveKeyValues.getIntValues("height",0);
        weight = SaveKeyValues.getIntValues("weight",0);
        length = SaveKeyValues.getIntValues("length",0);
    }

    /**
     * 获取当日日期
     */
    private void getTodayDate() {
        Map<String,Object> map = DateUtils.getDate();
        now_year = (int) map.get("year");
        now_month = (int) map.get("month");
        now_day = (int) map.get("day");
    }

    @Override
    protected void initViews() {
        //1、更换头像
        head_image = (CircleImageView) findViewById(R.id.head_pic);
        change_image = (TextView) findViewById(R.id.change_image);
        //2、更换名称
        change_nick = (EditText) findViewById(R.id.change_nick);
        //3、更改性别
        change_gender = (RadioGroup) findViewById(R.id.change_gender);
        //4、更改生日
        change_birthDay = (TextView) findViewById(R.id.change_date);
        //确定并退出界面
        change_OK_With_Save = (Button) findViewById(R.id.change_ok);

        //修改参数
        change_height = (EditText) findViewById(R.id.change_height);
        change_weight = (EditText) findViewById(R.id.change_weight);
        change_length = (EditText) findViewById(R.id.change_length);
    }

    @Override
    protected void setViewsListener() {
        change_image.setOnClickListener(this);
        change_OK_With_Save.setOnClickListener(this);
        change_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                hideKeyBoard();
                switch (checkedId) {
                    case R.id.change_girl:
                        sex_str = "女";
                        break;
                    case R.id.change_boy:
                        sex_str = "男";
                        break;
                    default:
                        break;
                }
            }
        });
        change_birthDay.setOnClickListener(this);
    }

    /**
     * 隐藏输入键盘
     */
    private void  hideKeyBoard(){
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(CompileDetailsActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 从相册获取
     */
    public void gallery() {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);//ACTION_OPEN_DOCUMENT
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/jpeg");
        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.KITKAT){
            startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
        }else{
            startActivityForResult(intent, PHOTO_REQUEST_GALLERY2);
        }
    }

    /**
     * 从相机获取
     */
    public void camera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME)));
        }
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    @Override
    protected void setViewsFunction() {

    }
}
