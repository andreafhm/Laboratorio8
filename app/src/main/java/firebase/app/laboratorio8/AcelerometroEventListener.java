package firebase.app.laboratorio8;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class AcelerometroEventListener implements SensorEventListener {

    private static final String TAG = "AcelerometroEventListener";
    private float x, y ,z;
    private float alpha = (float) 0.8;
    private float mHighPassX, mHighPassY, mHighPassZ;
    private float mLastX, mLastY, mLastZ;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];
        Log.d(TAG, "CURRENT: " + x + ","+ y + ","+ z);

        mHighPassX = highPass(x, mLastX, mHighPassX);
        mHighPassY = highPass(y, mLastY, mHighPassY);
        mHighPassZ = highPass(z, mLastZ, mHighPassZ);
        mLastX = x;
        mLastY = y;
        mLastX = z;

        Log.d(TAG, "FILTER: " + mHighPassX + "," + mHighPassY + "," + mHighPassZ);

        

        //gravity = new float[3];
        //linear_acceleration = new float[3];



        /**gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
        gravity[1] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[1];
        gravity[2] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[2];

        linear_acceleration[0] = sensorEvent.values[0] - gravity[0];
        linear_acceleration[1] = sensorEvent.values[1] - gravity[1];
        linear_acceleration[2] = sensorEvent.values[2] - gravity[2];


        acelX.setText(String.valueOf(linear_acceleration[0]));
        acelY.setText(String.valueOf(linear_acceleration[1]));
        acelZ.setText(String.valueOf(linear_acceleration[2])); **/

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.d(TAG, ""+ sensor.getName());

    }

    float highPass (float current, float last, float filtered){
        return  alpha * (filtered + current - last);
    }
}
