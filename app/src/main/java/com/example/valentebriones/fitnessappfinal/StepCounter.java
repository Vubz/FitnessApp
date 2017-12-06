package com.example.valentebriones.fitnessappfinal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class StepCounter extends Fragment implements SensorEventListener{

    TextView tv_steps;
    SensorManager Smanager;

    boolean running = false;

    public StepCounter() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View = inflater.inflate(R.layout.fragment_step_counter, container, false);

        tv_steps = (TextView) View.findViewById(R.id.textSteps);
        Smanager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        return View;
    }

    @Override
    public void onResume() {
        super.onResume();
        running = true;
        Sensor countSensor = Smanager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null){
            Smanager.registerListener(this, countSensor,Smanager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(getContext(), "Sensor not found",Toast.LENGTH_SHORT).show();;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        running = false;
        //To stop detection
        //Smanager.unregisterDynamicSensorCallback();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (running){
            tv_steps.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
