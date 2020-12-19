package mrkj.healthylife.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取日期
 */
public class DateUtils {
    /**
     * 获取日期
     * @return
     */
    public static Map<String,Object> getDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        map.put("month",month);
        map.put("day",day);
        map.put("hour",hour);
        map.put("minute",minute);
        map.put("date",year+"-"+month+"-"+day);
        return map;
    }

}
