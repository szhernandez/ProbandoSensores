package com.example.windows.probandosensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends ActionBarActivity implements SensorEventListener, View.OnClickListener {

    private TextView salida1, salida2, salida3, salida4;
    private RadioButton RB1, RB2, RB3, RB4, RB5;
    String string1, string2, string3, bandera;
    SensoresAndroid sensoresAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida1 = (TextView) findViewById(R.id.salida1);
        salida2 = (TextView) findViewById(R.id.salida2);
        salida3 = (TextView) findViewById(R.id.salida3);
        salida4 = (TextView) findViewById(R.id.salida4);
        RB1 = (RadioButton) findViewById(R.id.RB_proximidad);
        RB2 = (RadioButton) findViewById(R.id.RB_aceleracion);
        RB3 = (RadioButton) findViewById(R.id.RB_magnetico);
        RB4 = (RadioButton) findViewById(R.id.RB_orientacion);
        RB5 = (RadioButton) findViewById(R.id.RB_rotacion);
        RB1.setOnClickListener(this);
        RB2.setOnClickListener(this);
        RB3.setOnClickListener(this);
        RB4.setOnClickListener(this);
        RB5.setOnClickListener(this);
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
        switch (item.getItemId()) {
           /* case R.id.iniciar:
                return true;
            case R.id.detener:
                SensoresAndroid sensoresA = new SensoresAndroid();
                //sensoresA.iniciar_proximidad();
                return true;
            case R.id.limpiar:
                limpiar();
                return true;
            case R.id.ver:
                Intent intent = new Intent(getBaseContext(), Ver_sensor.class);
                startActivity(intent);
                return true;
                */
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        synchronized (this) {
            switch (event.sensor.getType()) {
                //OK
                case Sensor.TYPE_ORIENTATION:
                    if (RB4.isChecked()) {


                        string1 = getString(R.string.azimuth) +" "+ event.values[0];
                        string2 = getString(R.string.pitch) +" "+ event.values[1];
                        string3 = getString(R.string.roll) +" "+ event.values[2];
                        mostrar2(string1, string2, string3, "");
                    }
                    break;
                //OK
                case Sensor.TYPE_ACCELEROMETER:
                    if (RB2.isChecked()) {
                        string1 = getString(R.string.Acelerometro_x) +" "+ event.values[0];
                        string2 = getString(R.string.Acelerometro_y) +" "+ event.values[1];
                        string3 = getString(R.string.Acelerometro_z) +" "+ event.values[2];
                        mostrar2(string1, string2, string3, "");
                    }
                    break;
                //NO
                case Sensor.TYPE_GYROSCOPE:
                  /*  string1= "Eje X: "+event.values[0];
                    string2= "Eje Y: "+event.values[1];
                    string3= "Eje Z: "+event.values[2];
                    mostrar(string1,string2,string3);
                  */
                    break;
                //OK
                case Sensor.TYPE_MAGNETIC_FIELD:
                    if (RB3.isChecked()) {
                        string1 = getString(R.string.magnetico_x) +" "+ event.values[0];
                        string2 = getString(R.string.magnetico_y) +" "+ event.values[1];
                        string3 = getString(R.string.magnetico_z) +" "+ event.values[2];
                        mostrar2(string1, string2, string3, "");
                    }
                    break;
                //OK
                case Sensor.TYPE_PROXIMITY:
                    if (RB1.isChecked()) {
                        string1 = getString(R.string.proximidad_ver) +" "+ event.values[0];
                        mostrar2(string1, "", "", "");
                    }
                    break;
                case Sensor.TYPE_GRAVITY:
                    // log("Gravedad: "+event.values[0]);
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    if (RB5.isChecked()) {
                        try {
                            string1 = getString(R.string.rotacion_x) +" "+ event.values[0];
                            string2 = getString(R.string.rotacion_y) +" "+ event.values[1];
                            string3 = getString(R.string.rotacion_z) +" "+ event.values[2];
                            mostrar(string1, string2, string3);
                        } catch (Exception e) {
                            Log.e("ERROR", "ERROR IN CODE: " + e.toString());
                        }
                    }
                    break;
                default:
                   /* for (int i=0 ; i<event.values.length ; i++) {
                        log("Temperatura "+i+": "+event.values[i]);
                    }
                    */
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    private void mostrar(String v1, String v2, String v3) {
        salida1.setText(v1);
        salida2.setText(v2);
        salida3.setText(v3);
    }

    private void mostrar2(String v1, String v2, String v3, String v4) {
        salida1.setText(v1);
        salida2.setText(v2);
        salida3.setText(v3);
        salida4.setText(v4);
    }

    private void limpiar() {
        salida1.setText("");
        salida2.setText("");
        salida3.setText("");
        salida4.setText("");
    }

    @Override
    protected void onStop() {
        detenerSensores();
        super.onStop();
    }

    @Override
    protected void onPause() {
        detenerSensores();
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        detenerSensores();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.RB_proximidad:
                limpiar();
                detenerSensores();
                iniciar_proximidad();
                break;
            case R.id.RB_aceleracion:
                limpiar();
                detenerSensores();
                iniciar_acelerometro();
                break;
            case R.id.RB_magnetico:
                limpiar();
                detenerSensores();
                iniciar_magnetico();
                break;
            case R.id.RB_orientacion:
                limpiar();
                detenerSensores();
                iniciar_orientacion();
                break;
            case R.id.RB_rotacion:
                limpiar();
                detenerSensores();
                iniciar_rotacion_vector();
                break;
        }
    }

    public void iniciar_orientacion() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }

    }

    public void iniciar_acelerometro() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    public void iniciar_giroscopio() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }
    }

    public void iniciar_magnetico() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    public void iniciar_temperatura() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
        if (!listaSensores.isEmpty()) {
            Sensor temperatureSensor = listaSensores.get(0);
            sensorManager.registerListener(this, temperatureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void iniciar_proximidad() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);

        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void iniciar_gravedad() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);

        if (!listaSensores.isEmpty()) {
            Sensor gravitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, gravitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void iniciar_rotacion_vector() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ROTATION_VECTOR);
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ROTATION_VECTOR);
        if (!listaSensores.isEmpty()) {
            Sensor rotacionSensor = listaSensores.get(0);
            sensorManager.registerListener(this, rotacionSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }


    }

    public void detenerSensores() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(orientationSensor.TYPE_ORIENTATION));
        }

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(acelerometerSensor.TYPE_ACCELEROMETER));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(giroscopioSensor.TYPE_GYROSCOPE));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(magneticSensor.TYPE_MAGNETIC_FIELD));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
        if (!listaSensores.isEmpty()) {
            Sensor temperatureSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(temperatureSensor.TYPE_TEMPERATURE));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(proximitySensor.TYPE_PROXIMITY));
        }
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);
        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(orientationSensor.TYPE_GRAVITY));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ROTATION_VECTOR);
        if (!listaSensores.isEmpty()) {
            Sensor rotacionSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(rotacionSensor.TYPE_ROTATION_VECTOR));
        }
    }
}
