package com.jpimentel.myappsensoracelerometro;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Sensor sensor;
    SensorManager sensorManager;
    SensorEventListener sensorEventListener;
    int movimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        accionDelSensorAcelerometro();
        iniciarSensor();
    }

    private void accionDelSensorAcelerometro(){
        if(sensor != null){
            sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    float ejeX = sensorEvent.values[0];
                    if(ejeX < -5 && movimiento == 0){
                        movimiento++;
                    }
                    else if(ejeX > 5 && movimiento == 1){
                        movimiento++;
                    }
                    //----
                    if(movimiento == 2){
                        sonido();
                        movimiento = 0;
                    }
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

    private void sonido(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.ic_latigo);
        mediaPlayer.start();
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