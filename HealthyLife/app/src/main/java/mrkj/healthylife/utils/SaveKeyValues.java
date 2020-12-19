package mrkj.healthylife.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Administrator on 2016/5/25.
 */
public class SaveKeyValues {

    public  static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    /**
     * 初始化SharedPreferences
     * @param context
     */
    public static void createSharePreferences(Context context){
        String appName = context.getPackageName();
        Log.e("储存的文件名",appName);
        sharedPreferences = context.getSharedPreferences(appName, Context.MODE_WORLD_WRITEABLE);
        editor = sharedPreferences.edit();
    }

}
