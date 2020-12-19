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

    /**
     * 判断SharedPreferences是否被创建
     * @return
     */
    public static boolean isUnCreate(){
        boolean result = (sharedPreferences == null) ? true : false;
        if (result){
            Log.e("提醒","sharedPreferences未被创建！");
        }
        return result;
    }

    /**
     * 存入String类型的值
     * @param key
     * @param values
     * @return
     */
    public static boolean putStringValues(String key,String values){
        if (isUnCreate()){
            return false;
        }
        editor.putString(key,values);
        return editor.commit();
    }

    /**
     * 取出String类型的值
     * @param key
     * @param defValue
     * @return
     */
    public static String getStringValues(String key,String defValue){
        if (isUnCreate()){
            return null;
        }
        String string_value = sharedPreferences.getString(key,defValue);
        return string_value;
    }

    /**
     * 存入int类型的值
     * @param key
     * @param values
     * @return
     */
    public static boolean putIntValues(String key,int values){
        if (isUnCreate()){
            return false;
        }
        editor.putInt(key, values);
        return editor.commit();
    }

}
