package mrkj.healthylife.utils;

import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库
 */
public class DBHelper {

    private SQLiteDatabase db;
    public DBHelper(){
        db = SQLiteDatabase.openOrCreateDatabase(BringData.DATA_PATH+BringData.DATA_NAME,null);
    }

}
