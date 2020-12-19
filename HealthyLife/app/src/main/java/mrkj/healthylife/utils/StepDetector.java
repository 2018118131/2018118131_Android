package mrkj.healthylife.utils;

import android.content.Context;
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

	public static int CURRENT_SETP = 0;
	public int walk = 0;
	public static float SENSITIVITY = 8; // SENSITIVITY灵敏度

	private float mLastValues[] = new float[3 * 2];
	private float mScale[] = new float[2];
	private float mYOffset;//位移
	private static long mEnd = 0;//运动相隔时间
	private static long mStart = 0;//运动开始时间
	private Context context;

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}
}
