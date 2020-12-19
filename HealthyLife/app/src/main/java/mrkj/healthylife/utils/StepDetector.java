package mrkj.healthylife.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * 实现计步的算法
 * 网上有相关的算法
 * 首先计步的算法就是根据手机的X,Y,Z加速度算出来的
 * 欧了一段开源代码来完成计步的算法
 */
public class StepDetector implements SensorEventListener {


	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}
}
