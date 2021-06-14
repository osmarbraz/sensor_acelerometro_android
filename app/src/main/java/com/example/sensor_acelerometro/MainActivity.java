package com.example.sensor_acelerometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //Componentes a serem manipulados
    private Button buttonFechar;
    private TextView eixox;
    private TextView eixoy;
    private TextView eixoz;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associa os componentes da interface aos componentes da classe
        buttonFechar = findViewById(R.id.buttonFechar);
        eixox = findViewById(R.id.eixox);
        eixoy = findViewById(R.id.eixoy);
        eixoz = findViewById(R.id.eixoz);

        //Recupera o gerenciador de sensores
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //Recupera o sensor do tipo acelerômetro.
        mAccelerometer  = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Associa o listener ao sensor
        mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // Força de aceleração ao longo do eixo X (incluindo a gravidade).
        float x = event.values[0];
        // Força de aceleração ao longo do eixo Y (incluindo a gravidade).
        float y = event.values[1];
        // Força de aceleração ao longo do eixo Z (incluindo a gravidade).
        float z = event.values[2];

        //Exibe os dados do sensor
        eixox.setText("x:" + x);
        eixoy.setText("y:" + y);
        eixoz.setText("z:" + z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracia) {

    }

    public void onClickBotaoFechar(View v) {
        System.exit(0);
    }
}