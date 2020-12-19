package mrkj.healthylife.utils;

/**
 * 放置常量
 */
public class Constant {

    //加载布局的变量
    public static final int TURN_MAIN = 1;//加载运动界面
    public static final int MAKE_PLAN = 2;//加载发现界面

    //每个Fragment的Tag值
    public static final String SPORT_TAG = "sport";//运动TAG
    public static final String FIND_TAG = "find";//发现TAG
    public static final String HEART_TAG = "heart";//心率TAG
    public static final String MINE_TAG = "mine";//我的TAG

    //天气预报接口
    //APP_KEY
    public static final String APP_KEY = "06ba330de85cf5484fedbcd1c2247e28";
    //天气预报数据接口
    public static final String GET_DATA = "http://op.juhe.cn/onebox/weather/query?cityname=%s&key="+APP_KEY;
//    http://op.juhe.cn/onebox/weather/query?cityname=长春&key=06ba330de85cf5484fedbcd1c2247e28

}