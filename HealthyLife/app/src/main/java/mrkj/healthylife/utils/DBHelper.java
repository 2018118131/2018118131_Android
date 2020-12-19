package mrkj.healthylife.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库
 */
public class DBHelper {

    private SQLiteDatabase db;
    public DBHelper(){
        db = SQLiteDatabase.openOrCreateDatabase(BringData.DATA_PATH+BringData.DATA_NAME,null);
    }

    /**
     * 查询数据库
     * @param table
     * @param columns
     * @param selection
     * @param selectionArgs
     * @param groupBy
     * @param having
     * @param orderBy
     * @return
     */
    public Cursor select (String table, String[] columns,
                          String selection, String[] selectionArgs, String groupBy,
                          String having, String orderBy){
        return  db.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);


    }

}
