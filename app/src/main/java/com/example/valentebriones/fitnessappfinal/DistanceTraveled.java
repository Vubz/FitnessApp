package com.example.valentebriones.fitnessappfinal;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DistanceTraveled extends Fragment implements LocationListener {
    TextView distance;


    public DistanceTraveled() {
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
        View vista = inflater.inflate(R.layout.fragment_distance_traveled, container, false);
        distance = (TextView) vista.findViewById(R.id.textDistance);


        LocationManager lm = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return vista;

        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this.getActivity());

            this.onLocationChanged(null);


        return vista;
    }


    @Override
    public void onLocationChanged(Location location) {


        if(location==null){
            distance.setText("-.- m/s");
        }
        else
        {
            float nCurrentSpeed = location.getSpeed();
            distance.setText(nCurrentSpeed+ " m/s");
        }

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
