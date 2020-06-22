package firebase.app.laboratorio8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    TextView acelX, acelY, acelZ;
    Sensor acelerometro;
    SensorManager sm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acelX = (TextView) findViewById(R.id.acelX);
        acelY = (TextView) findViewById(R.id.acelY);
        acelZ = (TextView) findViewById(R.id.acelZ);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acelerometro = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        AcelerometroEventListener acelerometroEventListener = new AcelerometroEventListener();

        sm.registerListener(acelerometroEventListener,acelerometro,SensorManager.SENSOR_DELAY_NORMAL);
    }

    
}
