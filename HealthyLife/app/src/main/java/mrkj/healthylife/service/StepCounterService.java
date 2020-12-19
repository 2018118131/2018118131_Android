package mrkj.healthylife.service;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import java.util.Calendar;

import mrkj.healthylife.utils.StepDetector;

/**
 * 计步服务
 *
 * @author Administrator
 */
public class StepCounterService extends Service {

    public static final String alarmSaveService = "mrkj.healthylife.SETALARM";
    private static final String TAG = "StepCounterService";
    public static Boolean FLAG = false;// 服务运行标志

    private SensorManager mSensorManager;// 传感器服务
    public StepDetector detector;// 传感器监听对象

    private PowerManager mPowerManager;// 电源管理服务
    private PowerManager.WakeLock mWakeLock;// 屏幕灯
    private AlarmManager alarmManager;//闹钟管理器
    private PendingIntent pendingIntent;//延迟意图
    private Calendar calendar;//日期
    private Intent intent;//意图


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
