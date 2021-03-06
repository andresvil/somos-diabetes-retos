package com.example.andresvil.retos;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by andresvil on 3/18/16.
 */
public class RetosAdapter extends ArrayAdapter {

    private List myList = new ArrayList();

    public RetosAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Reto reto) {
        myList.add(reto);
        super.add(reto);
    }

    static class ImgHolder
    {
        TextView RETO;
        ImageView CHECK;
    }

    @Override
    public int getCount() {
        return this.myList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myList.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImgHolder holder;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.retos_layout, parent, false);
            holder = new ImgHolder();
            holder.RETO = (TextView) row.findViewById(R.id.reto);
            holder.CHECK = (ImageView) row.findViewById(R.id.img);

            row.setTag(holder);
        }

        else
        {
            holder = (ImgHolder) row.getTag();
        }

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("item clicked!", Integer.toString(position));
            }
        });

        Reto reto = (Reto) getItem(position);

        // Set textviews for Pregunta & Respuesta
        holder.RETO.setText(reto.getRetoTexto());
        holder.CHECK.setImageResource(reto.getImg_rsc());

        // Load font and set TextViews to that font
        AssetManager am = getContext().getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        holder.RETO.setTypeface(myFont);

        return row;
    }
}
