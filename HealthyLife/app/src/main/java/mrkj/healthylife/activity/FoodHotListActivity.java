package mrkj.healthylife.activity;

import android.graphics.Bitmap;
import android.widget.ExpandableListView;

import java.util.List;

import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.entity.FoodType;

public class FoodHotListActivity extends BaseActivity {

    private int sign= - 1 ; //控制列表的展开
    private String[] food_type_array;//食物类型数组
    private List<FoodType> food_list;//数据集合
    private ExpandableListView data_list;//折叠listview
    private Bitmap[] bitmaps;//图片资源
    private int[] ids;//图片资源ID数组

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
