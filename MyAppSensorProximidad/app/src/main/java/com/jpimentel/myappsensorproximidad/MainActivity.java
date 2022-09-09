package com.jpimentel.myappsensorproximidad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Sensor sensor;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Define la activacion y uso de un sensor a futuro
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //Define el tipo de sensor que se va a utilizar
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        accionDelSensorProximidad();
        iniciarSensor();
    }

    private void accionDelSensorProximidad(){
        if(sensor != null){
            sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    if(sensorEvent.values[0] < sensor.getMaximumRange()){
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                        getWindow().getDecorView().setBackground(getDrawable(R.drawable.ic_launcher_background));
                    }else
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
        }else {
            Toast.makeText(this, "No cuenta con el sensor a utilizar", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //Metodo que inician y detienen la accion y escucha del sensor
    private void iniciarSensor(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    private void detenerSensor(){
        sensorManager.unregisterListener(sensorEventListener);
    }
    //Metodo que se encargaran del comportamiento de la actividad para el sensor
    @Override
    protected void onResume() {
        super.onResume();
        iniciarSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detenerSensor();
    }
}