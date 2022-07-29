package com.jpimentel.myapplistapersonalizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterPersonalizadoSecundario extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    private ArrayList<Integer> imgDetalle = new ArrayList<>();
    private ArrayList<String> nomDetalle = new ArrayList<>();
    private ArrayList<String> apeDetalle = new ArrayList<>();
    private ArrayList<Integer> edadDetalle = new ArrayList<>();

    public AdapterPersonalizadoSecundario(Context context, int referenciaLista, ArrayList<Integer> imgDetalle, ArrayList<String> nomDetalle, ArrayList<String> apeDetalle, ArrayList<Integer> edadDetalle) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.imgDetalle = imgDetalle;
        this.nomDetalle = nomDetalle;
        this.apeDetalle = apeDetalle;
        this.edadDetalle = edadDetalle;
    }

    @Override
    public int getCount() {
        return this.nomDetalle.size();
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
        v = layoutInflater.inflate(R.layout.lista_personalizada_secundaria, null);

        int imgDetalleDato = this.imgDetalle.get(i);
        String nomDetalleDato = this.nomDetalle.get(i);
        String apeDetalleDato = this.apeDetalle.get(i);
        int edadDetalleDato = this.edadDetalle.get(i);

        ImageView imageView = v.findViewById(R.id.imgUserDetalle);
        TextView textViewNom = v.findViewById(R.id.txtNombreDetalle);
        TextView textViewApe = v.findViewById(R.id.txtApellidoDetalle);
        TextView textViewEdad = v.findViewById(R.id.txtEdadDetalle);
        Button button = v.findViewById(R.id.btnEstadoDetalle);

        imageView.setImageResource(imgDetalleDato);
        textViewNom.setText(String.valueOf(nomDetalleDato));
        textViewApe.setText(String.valueOf(apeDetalleDato));
        textViewEdad.setText(String.valueOf(edadDetalleDato));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "El estado de "+nomDetalleDato+" es "+estado(edadDetalleDato), Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }

    private String estado(int edad){
        String estado;
        if(edad > 26){
            estado = "Activo";
        }
        else {
            estado = "Inactivo";
        }
        return estado;
    }
}
