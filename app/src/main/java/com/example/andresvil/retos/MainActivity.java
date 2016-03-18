package com.example.andresvil.retos;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView activos = (TextView) findViewById(R.id.buttonActivos);
        TextView completados = (TextView) findViewById(R.id.buttonCompletados);
        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<String> retos = new ArrayList<String>();
        retos.add("Me están doliendo los pies en la última semana pero no veo " +
                "cambio visible.");
        retos.add("He estado bajo de energía y he seguido la dieta, ¿Qué será?");
        retos.add("Me están doliendo los pies en la última semana pero no veo " +
                "cambio visible.");
        retos.add("He estado bajo de energía y he seguido la dieta, ¿Qué será?");

        // Create and set adapter to listview
        RetosAdapter adapter = new RetosAdapter(getApplicationContext(), R.layout.retos_layout);
        listView.setAdapter(adapter);

        // Add retos to RetosAdapter
        for (int i = 0; i < retos.size(); i++)
        {
            adapter.add(retos.get(i));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Load font and set TextViews to that font
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        activos.setTypeface(myFont);
        completados.setTypeface(myFont);

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
}
