package mrkj.healthylife.utils;

import android.content.Context;
import android.util.Log;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;

/**
 * 位置信息配置
 */
public class GetLocation {
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    public GetLocation(Context context){
        mLocationClient = new LocationClient(context);//声明LocationClient类
        initLocation();
        mLocationClient.registerLocationListener(myListener);
        Log.e("执行了", "?");
        mLocationClient.start();
    }

}
