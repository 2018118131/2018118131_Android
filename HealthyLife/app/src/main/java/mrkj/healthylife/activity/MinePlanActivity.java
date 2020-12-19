package mrkj.healthylife.activity;

import android.database.Cursor;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mrkj.healthylife.R;
import mrkj.healthylife.adapter.MyAdapter;
import mrkj.healthylife.base.BaseActivity;
import mrkj.healthylife.db.DatasDao;

public class MinePlanActivity extends BaseActivity {

    private List<Map<String,Object>> plan_List;//储存计划数据
    private ListView listView;//列表
    private DatasDao datasDao;//数据库操作诶
    private Cursor cursor;//游标
    private MyAdapter myAdapter;//适配器

    @Override
    protected void setActivityTitle() {
        initTitle();//初始化标题栏
        setTitle("我的计划", this);
        setMyBackGround(R.color.watm_background_gray);//设置标题栏的背景颜色
        setTitleTextColor(R.color.theme_blue_two);//设置字体的颜色
        setTitleLeftImage(R.mipmap.mrkj_back_blue);//设施返回键的图片
    }

    /**
     * 初始化界面布局
     */
    @Override
    protected void getLayoutToView() {
        setContentView(R.layout.activity_mine_plan);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initValues() {
        plan_List = new ArrayList<>();
        datasDao = new DatasDao(this);
        cursor = datasDao.selectAll("plans");//获取游标用来查询
        //遍历所有数据
        while (cursor.moveToNext()){
            Map<String,Object> map = new HashMap<>();
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            int type = cursor.getInt(cursor.getColumnIndex("sport_type"));
            int s_year = cursor.getInt(cursor.getColumnIndex("start_year"));
            int s_month = cursor.getInt(cursor.getColumnIndex("start_month"));
            int s_day = cursor.getInt(cursor.getColumnIndex("start_day"));
            int t_year = cursor.getInt(cursor.getColumnIndex("stop_year"));
            int t_month = cursor.getInt(cursor.getColumnIndex("stop_month"));
            int t_day = cursor.getInt(cursor.getColumnIndex("stop_day"));
            String h_time = cursor.getString(cursor.getColumnIndex("hint_str"));
            if (s_year == t_year && s_month == t_month & s_day == t_day){
                map.put("date",s_year+"-"+s_month+"-"+s_day);
            }else {
                map.put("date",s_year+"-"+s_month+"-"+s_day+"~"+t_year+"-"+t_month+"-"+t_day);
            }
            map.put("id",id);
            map.put("type",type);
            map.put("time",h_time);
            //向集合中添加数据
            plan_List.add(map);
        }
        //关闭游标
        cursor.close();
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {
        listView = (ListView) findViewById(R.id.plan_list);
    }

    @Override
    protected void setViewsListener() {

    }

    @Override
    protected void setViewsFunction() {

    }
}
