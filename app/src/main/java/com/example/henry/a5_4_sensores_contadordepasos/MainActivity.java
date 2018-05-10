package com.example.henry.a5_4_sensores_contadordepasos;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView textPasos;
    private SensorManager sensorManager;
    private Sensor sensor;
    private int mStep;
    private int totalpasos;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPasos = findViewById(R.id.textPasos);
        btnReset = findViewById(R.id.btnReset);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    btnReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            totalpasos = 0;
            textPasos.setText(totalpasos+"");
        }
    });

    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]== 1.0f){
            mStep++;
        }
        textPasos.setText(mStep+"");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
