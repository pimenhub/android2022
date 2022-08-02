package com.jpimentel.myappgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGrid extends BaseAdapter {

    private Context context;
    int referenciaGrid;
    ArrayList<Integer> imagenes = new ArrayList<>();
    ArrayList<String> nombres = new ArrayList<>();

    public AdapterGrid(Context context, int referenciaGrid, ArrayList<Integer> imagenes, ArrayList<String> nombres) {
        this.context = context;
        this.referenciaGrid = referenciaGrid;
        this.imagenes = imagenes;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.grid_personalizado, null);

        int imagenDato = imagenes.get(i);
        String nombreDato = nombres.get(i);
        ImageView imageView = v.findViewById(R.id.imgGrid);
        TextView textView = v.findViewById(R.id.txtGrid);

        imageView.setImageResource(imagenDato);
        textView.setText(String.valueOf(nombreDato));

        return v;
    }
}
