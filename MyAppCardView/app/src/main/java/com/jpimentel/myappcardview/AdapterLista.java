package com.jpimentel.myappcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLista extends BaseAdapter {
    private Context context;
    private int referenciaLista;
    ArrayList<String> saludo = new ArrayList<>();

    public AdapterLista(Context context, int referenciaLista, ArrayList<String> saludo) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.saludo = saludo;
    }

    @Override
    public int getCount() {
        return this.saludo.size();
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
        v = layoutInflater.inflate(R.layout.list_card,null);

        String texto = saludo.get(i);

        TextView textView = v.findViewById(R.id.txtSaludo);
        textView.setText(String.valueOf(texto));

        return v;
    }
}
