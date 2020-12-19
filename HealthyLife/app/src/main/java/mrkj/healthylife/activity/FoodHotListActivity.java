package mrkj.healthylife.activity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import mrkj.healthylife.R;
import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.entity.FoodMessage;
import mrkj.healthylife.entity.FoodType;
import mrkj.healthylife.utils.DBHelper;

public class FoodHotListActivity extends BaseActivity {

    private int sign= - 1 ; //控制列表的展开
    private String[] food_type_array;//食物类型数组
    private List<FoodType> food_list;//数据集合
    private ExpandableListView data_list;//折叠listview
    private Bitmap[] bitmaps;//图片资源
    private int[] ids;//图片资源ID数组

    /**
     * 设置标题栏
     */
    @Override
    protected void setActivityTitle() {
        initTitle();
        setTitle("食物热量对照表", this);
        setMyBackGround(R.color.watm_background_gray);
        setTitleTextColor(R.color.theme_blue_two);
        setTitleLeftImage(R.mipmap.mrkj_back_blue);
    }

    /**
     * 设置界面布局
     */
    @Override
    protected void getLayoutToView() {
        setContentView(R.layout.activity_food_hot_list);

    }

    /**
     * 初始化数据资源
     */
    @Override
    protected void initValues() {
        ids = new int[]{R.mipmap.mrkj_gu, R.mipmap.mrkj_cai,
                R.mipmap.mrkj_guo, R.mipmap.mrkj_rou, R.mipmap.mrkj_dan,
                R.mipmap.mrkj_yv, R.mipmap.mrkj_nai, R.mipmap.mrkj_he,
                R.mipmap.mrkj_jun, R.mipmap.you};
        bitmaps = new Bitmap[ids.length];
        for (int i = 0;i < ids.length ; i++){
            bitmaps[i] = BitmapFactory.decodeResource(getResources(),ids[i]);
        }
        food_type_array = new String[]{"五谷类",
                "蔬菜类", "水果类", "肉类",
                "蛋类", "水产类", "奶类",
                "饮料类", "菌藻类", "油脂类"};
        food_list = new ArrayList<>();
        //构造数据源
        DBHelper dbHelper = new DBHelper();
        Cursor cursor = dbHelper.selectAllDataOfTable("hot");
//        Log.e("数据数量", cursor.getCount() + "");
//        int j = 0;
        for (int i = 0; i < 10; i++) {
            FoodType foodType = null;
            List<FoodMessage> foods = null;
            int counts = 1;
            while (cursor.moveToNext()) {
//                Log.e("计数", (++j) + "");
//                Log.e("counts", counts + "");
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String hot = cursor.getString(cursor.getColumnIndex("hot"));
                String type_name = cursor.getString(cursor.getColumnIndex("type_name"));
                if (counts == 1) {
                    foodType = new FoodType();
                    foods = new ArrayList<>();
                    foodType.setFood_type(type_name);
//                    Log.e("type_name", type_name + "");

                }
                FoodMessage foodMessage = new FoodMessage();
                foodMessage.setFood_name(name);
                foodMessage.setHot(hot);
                foods.add(foodMessage);
                foodType.setFood_list(foods);
                if (counts == 20) {
                    food_list.add(foodType);
                    break;
                }
                counts++;
            }
        }
        cursor.close();
        Log.e("数据的长度", food_list.size() + "");
//        for (FoodType foodType : food_list) {
//            Log.e("食物类型", foodType.getFood_type() + "");
//            Log.e("食物数量",foodType.getFood_list().size() + "");
//        }
    }

    @Override
    protected void initViews() {
        data_list = (ExpandableListView) findViewById(R.id.food_list);
    }

    /**
     * 设置点击展开一个其余的都收起
     */
    @Override
    protected void setViewsListener() {
        data_list.setOnGroupClickListener( new  ExpandableListView.OnGroupClickListener() {

            @Override
            public   boolean  onGroupClick(ExpandableListView parent, View v,
                                           int  groupPosition,  long  id) {
                // TODO Auto-generated method stub
                if  (sign== - 1 ) {
                    // 展开被选的group
                    data_list.expandGroup(groupPosition);
                    // 设置被选中的group置于顶端
                    data_list.setSelectedGroup(groupPosition);
                    sign= groupPosition;
                }  else   if  (sign== groupPosition) {
                    data_list.collapseGroup(sign);
                    sign= - 1 ;
                }  else  {
                    data_list.collapseGroup(sign);
                    // 展开被选的group
                    data_list.expandGroup(groupPosition);
                    // 设置被选中的group置于顶端
                    data_list.setSelectedGroup(groupPosition);
                    sign= groupPosition;
                }
                return   true ;
            }
        });
    }

    @Override
    protected void setViewsFunction() {

    }
}
