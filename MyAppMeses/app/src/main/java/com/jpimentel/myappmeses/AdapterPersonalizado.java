package com.jpimentel.myappmeses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

//Se debe de realizar el extends de la clase BaseAdapter para poder utilizar los metodos
//abstractos que esta tiene y asi poder crear nuestro propio adapter
public class AdapterPersonalizado extends BaseAdapter {

    //Declaracion de variales a utilizar para el item personalizado de la lista
    private Context context;
    private int referenciaLista;
    ArrayList<Integer> numeroMes = new ArrayList<>();
    ArrayList<String> nombreMes = new ArrayList<>();
    ArrayList<Integer> descripcionCelebracionMes = new ArrayList<>();
    ArrayList<String> celebracionMes = new ArrayList<>();

    public AdapterPersonalizado(Context context, int referenciaLista,
                                ArrayList<Integer> numeroMes, ArrayList<String> nombreMes,
                                ArrayList<Integer> descripcionCelebracionMes, ArrayList<String> celebracionMes) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.numeroMes = numeroMes;
        this.nombreMes = nombreMes;
        this.descripcionCelebracionMes = descripcionCelebracionMes;
        this.celebracionMes = celebracionMes;
    }

    @Override
    public int getCount() {
        return this.numeroMes.size();
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
        //variable para el retorno, esta sera de tipo View
        View v = view;
        //nos permite realizar una implementacion de un view diseniado
        //el cual reconoce el contexto de donde se va a mostrar esa view
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.list_personalizada, null);

        //Recibimos la informacion por posicion de los arraylist
        int numeroDeMes = this.numeroMes.get(i);
        String nombreDeMes = this.nombreMes.get(i);
        int descripcionMes = this.descripcionCelebracionMes.get(i);
        String celebracion = this.celebracionMes.get(i);

        TextView textViewNumMes = v.findViewById(R.id.txtNumeroMes);
        TextView textViewNomMes = v.findViewById(R.id.txtNombreMes);
        TextView textViewAnio = v.findViewById(R.id.txtAnio);
        Button buttonVer = v.findViewById(R.id.btnVer);

        textViewNumMes.setText(String.valueOf(numeroDeMes));
        textViewNomMes.setText(String.valueOf(nombreDeMes));
        textViewAnio.setText(String.valueOf(anioActual()));

        //metodo del clic del boton...
        buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trasladarDatos(nombreDeMes, celebracion, descripcionMes);
            }
        });

        return v;
    }


    private int anioActual(){
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        return anio;
    }

    private void trasladarDatos(String nomMes, String celebracion, int descripcion){
        Intent intent = new Intent(context, MACelebraciones.class);
        intent.putExtra("nomMes", nomMes);
        intent.putExtra("celebracion", celebracion);
        intent.putExtra("descripcion", descripcion);
        context.startActivity(intent);
    }
}
