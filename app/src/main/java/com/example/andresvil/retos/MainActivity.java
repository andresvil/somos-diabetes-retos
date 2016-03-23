package com.example.andresvil.retos;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button activosButton;
    Button completadosButton;
    ListView activosList;
    ListView completadosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Remove default title from ActionBar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Find buttons, textviews and listviews
        activosButton = (Button) findViewById(R.id.buttonActivos);
        completadosButton = (Button) findViewById(R.id.buttonCompletados);
        TextView activos = (TextView) findViewById(R.id.buttonActivos);
        TextView completados = (TextView) findViewById(R.id.buttonCompletados);
        activosList = (ListView) findViewById(R.id.activosListView);
        completadosList = (ListView) findViewById(R.id.completadosListView);
        TextView toolbarText = (TextView) findViewById(R.id.toolbar_title);

        // Populate Retos Activos List
        final ArrayList<String> retosActivos = new ArrayList<String>();
        retosActivos.add("Me están doliendo los pies en la última semana pero no veo " +
                "cambio visible.");
        retosActivos.add("He estado bajo de energía y he seguido la dieta, ¿Qué será?");
        retosActivos.add("Me están doliendo los pies en la última semana pero no veo " +
                "cambio visible.");
        retosActivos.add("He estado bajo de energía y he seguido la dieta, ¿Qué será?");

        // Create and set adapter to activosListview
        RetosAdapter adapter = new RetosAdapter(getApplicationContext(), R.layout.retos_layout);
        activosList.setAdapter(adapter);

        // Add retosActivos to RetosAdapter
        for (int i = 0; i < retosActivos.size(); i++)
        {
            Reto r = new Reto(retosActivos.get(i), R.drawable.inactivo);
            adapter.add(r);
        }

        // Populate Retos Completados List
        ArrayList<String> retosCompletados = new ArrayList<String>();
        retosCompletados.add("Tomar 2 litros de agua diario por una semana");
        retosCompletados.add("Hacer 25 minutos o más de ejercicio cardiovascular un mínimo " +
                "de 3 veces en una semana");
        retosCompletados.add("Mantener mi nivel de glucosa abajo de 200 toda la semana");
        retosCompletados.add("Salir a caminar 20 minutos después de desayunar");
        retosCompletados.add("No tomar más de un refresco el día de hoy");

        // Create and set adapter to completadosListView
        RetosAdapter rcAdapter = new RetosAdapter(getApplicationContext(), R.layout.retos_layout);
        completadosList.setAdapter(rcAdapter);

        // Add retosCompletados to RetosCompletadosAdapter
        for (int i = 0; i < retosCompletados.size(); i++)
        {
            Reto r = new Reto(retosCompletados.get(i), R.drawable.activo);
            rcAdapter.add(r);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AgregarRetos.class);
                startActivity(i);
            }
        });

        // Load font and set TextViews to that font
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        activos.setTypeface(myFont);
        completados.setTypeface(myFont);
        toolbarText.setTypeface(myFont);

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toRetosCompletados(View view)
    {
        activosButton.setEnabled(true);
        activosButton.setAlpha(0.5f);
        completadosButton.setEnabled(false);
        completadosButton.setAlpha(1);
        activosList.setVisibility(View.INVISIBLE);
        completadosList.setVisibility(View.VISIBLE);
    }

    public void toRetosActivos(View view)
    {
        activosButton.setEnabled(false);
        activosButton.setAlpha(1);
        completadosButton.setEnabled(true);
        completadosButton.setAlpha(0.5f);
        activosList.setVisibility(View.VISIBLE);
        completadosList.setVisibility(View.INVISIBLE);
    }
}
