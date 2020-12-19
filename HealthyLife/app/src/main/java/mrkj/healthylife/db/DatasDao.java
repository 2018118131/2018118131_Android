package mrkj.healthylife.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 */
public class DatasDao {
    private DatasDB myDB;
    private SQLiteDatabase db;

    public DatasDao(Context context) {
        // 实例化dbhelper类
        myDB = new DatasDB(context);
        // 得到一个数据库对象
        db = myDB.getWritableDatabase();
    }
}
