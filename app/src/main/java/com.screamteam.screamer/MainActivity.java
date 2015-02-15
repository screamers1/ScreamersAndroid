package com.screamteam.screamer;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements SensorEventListener, SensorListener {
private TextView rMain;
private SensorManager sensorManager;
private Long lastUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rMain = (TextView)findViewById(R.id.mainTextview);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
        sensorManager.registerListener(this, SensorManager.SENSOR_ACCELEROMETER);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }

        //current XYZ values
        float x = event.values[0], y = event.values[1], z = event.values[2];

        // Wilhelm Scream
        if((x < 2 || x > -2) && (y < 2 || y > -2) && (z < 2 || z > -2)){
            PlaySound.wilhelm()
          //display.Wilhelm() picture
            Thread.sleep(2000) /////// MAY CAUSE ERROR
        }

    }
    private void getAccelerometer (SensorEvent event){
        float [] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

//        float accelationSquareRoot = (x * x + y * y + z * z)/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;


        if (accelationSquareRoot >= 2){
            if (actualTime - lastUpdate < 200){
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(getApplicationContext(), "Device was shuffled!", Toast.LENGTH_LONG);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(int sensor, float[] values) {
        if (sensor == SensorManager.SENSOR_ACCELEROMETER){
            long curTime = System.currentTimeMillis();
            if ((curTime-lastUpdate))
        }
    }

    @Override
    public void onAccuracyChanged(int sensor, int accuracy) {

    }
*/
}
