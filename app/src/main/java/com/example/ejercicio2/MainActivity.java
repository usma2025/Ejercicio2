package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    private GoogleMap mMap;
    private MapView mMapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = (MapView) findViewById(R.id.map_view);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this::onMapReady);

        Button myButton = findViewById(R.id.btn_ingresar);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng ubicacion = new LatLng(4.652707040760889, -74.14454190393289);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,17));
    }

    @Override
    protected void onResume(){
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}