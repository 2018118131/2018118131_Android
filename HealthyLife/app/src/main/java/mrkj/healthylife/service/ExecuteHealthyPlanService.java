package mrkj.healthylife.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.List;

import mrkj.healthylife.db.DatasDao;
import mrkj.healthylife.entity.HealthyPlan;

/**
 * 执行运动计划的服务
 */
public class ExecuteHealthyPlanService extends Service {

    public static final String planSaveService = "mrkj.healthylife.PLAN";
    //用于操作数据库
    private DatasDao datasDao;
    private Intent toBroadReciver;
    private AlarmManager manager;
    private PendingIntent senser;
    //数据
    private List<HealthyPlan> plansList;//计划的集合
    //第一个数据的提示时间|id|序号|提示类型
    private long first_hint_time;
    private int first_hint_id;
    private int first_hint_num;
    private int first_hint_type;


    private int finish_plans;//完成计划

    public ExecuteHealthyPlanService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
