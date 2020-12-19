package mrkj.healthylife.db;

import android.content.ContentValues;
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

    // 添加数据
    public long insertValue(String table, ContentValues values) {

        long result = db.insert(table, null, values);
        return result;
    }

    // 修改数据
    public int updateValue(String table, ContentValues values, String whereClause, String[] whereArgs) {
        /**
         * table 要修改的表的表名 values 修改后的值 whereClause where关键子后的语句 id=？ whereArgs
         * 指的是whereClause里边？替换的值
         *
         */
        int result = db.update(table, values, whereClause, whereArgs);
        return result;
    }

}
