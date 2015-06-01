package com.example.windows.probandosensores;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;

import java.util.List;

/**
 * Created by Windows on 27/05/2015.
 */
public class SensoresAndroid extends MainActivity   {

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