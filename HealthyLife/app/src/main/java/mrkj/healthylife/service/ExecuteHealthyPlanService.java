package mrkj.healthylife.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import mrkj.healthylife.db.DatasDao;
import mrkj.healthylife.entity.HealthyPlan;
import mrkj.healthylife.utils.DateUtils;
import mrkj.healthylife.utils.SaveKeyValues;

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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        datasDao = new DatasDao(this);
        manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        finish_plans = SaveKeyValues.getIntValues("finish_plan" , 0);
//        toBroadReciver = new Intent(this, FunctionBroadcastReceiver.class);
//        senser = PendingIntent.getBroadcast(this, 0, toBroadReciver, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    //================================ 设置下一个定时任务 ================================
    /**
     * 设置下一个定时任务
     * @param oldID
     * @param oldNum
     */
    private void setToExecuteNextAlarmTask(int oldID,int oldNum) {
        Log.e("刚刚执行完的定时任务_ID","【"+ oldID +"】");
        Log.e("刚刚执行完的定时任务序号","【"+ oldNum +"】");
        //1、首先先判断执行过的任务的数据还是否有效-->判断任务的结束日期
        long nowDate = DateUtils.getNowDateMillisecondValues();//当前日期
        compareVerificationData(nowDate, oldID);//对刚刚执行玩的数据进行校验
        //2、判断当前是否是最后一个任务计划
        Cursor cursor = datasDao.selectAll("plans");//全查询
        if (cursor.getCount() == 1){//如果此时只剩一个任务时
            //则设置单个任务计划
            setTaskAtOnlyOneDataInDataList();
            return;
        }
        if (oldNum == cursor.getCount()){//此时执行完最后一个任务
            //重新排序并设置任务
            getHealthyDataAndSortDataToSetAlarm();
            return;
        }
        //3、根据序号查找相应的数据进行设置定时计划
        int nextNum = oldNum + 1;//下一个任务的序号
        long hintTime;
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("_id"));//id
            int hour = cursor.getInt(cursor.getColumnIndex("hint_hour"));//提醒时间-->时
            int minute = cursor.getInt(cursor.getColumnIndex("hint_minute"));//提醒时间-->分
            int number = cursor.getInt(cursor.getColumnIndex("number_values"));//顺序
            int hint_type = cursor.getInt(cursor.getColumnIndex("sport_type"));//类型
            if (number == nextNum){//查询出结果
                hintTime = DateUtils.getMillisecondValues(hour,minute);
                setAlarmService(2,id,number,hint_type,hintTime);//设置定时任务
                break;
            }
        }
    }

    /**
     * 校验数据
     * @param nowDate
     */
    private void compareVerificationData(long nowDate ,int oldID){
        Cursor cursor = datasDao.selectValue2("plans",null,"_id=?",new String[]{String.valueOf(oldID)},null,null,null);
        while (cursor.moveToNext()){
            int stop_year = cursor.getInt(cursor.getColumnIndex("stop_year"));//结束日期--->年
            int stop_month = cursor.getInt(cursor.getColumnIndex("stop_month"));//结束日期--->月
            int stop_day = cursor.getInt(cursor.getColumnIndex("stop_day"));//结束日期--->日
            long stopDate = DateUtils.getMillisecondValues(stop_year, stop_month, stop_day);
            if (stop_year == (int)(DateUtils.getDate().get("year"))
                    && stop_month == (int)(DateUtils.getDate().get("month"))
                    && stop_day == (int)(DateUtils.getDate().get("day"))){//此时意味着当前数据将不再保存在数据中-->删除该条数据
                finish_plans = SaveKeyValues.getIntValues("finish_plan" , 0);
                SaveKeyValues.putIntValues("finish_plan",++finish_plans);
                datasDao.deleteValue("plans", "_id=?", new String[]{String.valueOf(oldID)});
            }
        }
        cursor.close();
    }

    /**
     * 校验全部数据
     */
    private void compareAllData(){
//        long nowDate = DateUtils.getNowDateMillisecondValues();//当前日期
//        Map<String,Object>  times = DateUtils.getDate();
        Cursor cursor = datasDao.selectAll("plans");
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            int stop_year = cursor.getInt(cursor.getColumnIndex("stop_year"));//结束日期--->年
            int stop_month = cursor.getInt(cursor.getColumnIndex("stop_month"));//结束日期--->月
            int stop_day = cursor.getInt(cursor.getColumnIndex("stop_day"));//结束日期--->日
            Log.e("结束日期",stop_year +"-"+stop_month+"-"+stop_day );
//            long stopDate = DateUtils.getMillisecondValues(stop_year, stop_month, stop_day);
//            Log.e("当前时间",nowDate+"" );
//            Log.e("结束时间",stopDate+"" );
            Log.e("==","**************************" );

            if (stop_year == (int)(DateUtils.getDate().get("year"))
                    && stop_month == (int)(DateUtils.getDate().get("month"))
                    && stop_day == (int)(DateUtils.getDate().get("day"))){//此时意味着当前数据将不再保存在数据中-->删除该条数据
                Log.e("==","执行了" );
                finish_plans = SaveKeyValues.getIntValues("finish_plan" , 0);
                SaveKeyValues.putIntValues("finish_plan",++finish_plans);
                datasDao.deleteValue("plans", "_id=?", new String[]{String.valueOf(id)});
                break;
            }
        }
        cursor.close();
    }

}
