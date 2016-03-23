package com.example.andresvil.retos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class AgregarRetos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_retos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.retosDisponiblesListView);

        // Populate Retos Disponibles List
        ArrayList<String> retosDisponibles = new ArrayList<String>();
        retosDisponibles.add("Hacer 30 minutos de ejercicio cardiovascular hoy");
        retosDisponibles.add("Tomar pura agua el día de hoy");
        retosDisponibles.add("Dormir más de 6 horas");
        retosDisponibles.add("Tomar vitaminas y suplementos");
        retosDisponibles.add("Hacer 30 minutos de ejercicio cardiovascular hoy");
        retosDisponibles.add("Tomar pura agua el día de hoy");
        retosDisponibles.add("Dormir más de 6 horas");
        retosDisponibles.add("Tomar vitaminas y suplementos");

        // Create and set adapter to activosListview
        RetosAdapter adapter = new RetosAdapter(getApplicationContext(), R.layout.retos_layout);
        listView.setAdapter(adapter);

        // Add retosDisponibles to RetosAdapter
        for (int i = 0; i < retosDisponibles.size(); i++)
        {
            Reto r = new Reto(retosDisponibles.get(i), R.drawable.agregar_activo);
            adapter.add(r);
        }
    }

}
