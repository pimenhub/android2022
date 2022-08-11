package com.jpimentel.myapprepaso2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLista extends BaseAdapter {
    private Context context;
    private Integer referenciaLista;
    private ArrayList<String> nombreGenero = new ArrayList<>();
    private ArrayList<Integer> imgGenero = new ArrayList<>();

    public AdapterLista(Context context, Integer referenciaLista, ArrayList<String> nombreGenero, ArrayList<Integer> imgGenero) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.nombreGenero = nombreGenero;
        this.imgGenero = imgGenero;
    }

    @Override
    public int getCount() {
        return this.nombreGenero.size();
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
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.lista_personalizada,null);

        String nombre = this.nombreGenero.get(i);
        Integer img = this.imgGenero.get(i);

        TextView textView = v.findViewById(R.id.txtGeneroPersonalizado);
        ImageView imageView = v.findViewById(R.id.imgGeneroPersonalizado);

        textView.setText(String.valueOf(nombre));
        imageView.setImageResource(img);

        return v;
    }
}
