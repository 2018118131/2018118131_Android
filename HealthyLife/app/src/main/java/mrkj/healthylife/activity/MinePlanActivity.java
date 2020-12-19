package mrkj.healthylife.activity;

import android.database.Cursor;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

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
