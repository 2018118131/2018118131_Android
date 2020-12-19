package mrkj.healthylife.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

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

	/**
	 * 最后加速度方向
	 */
	private float mLastDirections[] = new float[3 * 2];//最后的方向
	private float mLastExtremes[][] = { new float[3 * 2], new float[3 * 2] };
	private float mLastDiff[] = new float[3 * 2];
	private int mLastMatch = -1;

	/**
	 * 传入上下文的构造函数
	 *
	 * @param context
	 */
	public StepDetector(Context context) {
		super();
		this.context = context;
		// 用于判断是否计步的值
		int h = 480;
		mYOffset = h * 0.5f;
		mScale[0] = -(h * 0.5f * (1.0f / (SensorManager.STANDARD_GRAVITY * 2)));//重力加速度
		mScale[1] = -(h * 0.5f * (1.0f / (SensorManager.MAGNETIC_FIELD_EARTH_MAX)));//地球最大磁场
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}
}
