package com.jpimentel.myapprecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

//Realizar el extends y solventar los errores
public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {
    //Declaramos la coleccion que nos permitira recibir datos
    private ArrayList<String> articulos = new ArrayList<>();
    //Creamos el constructor para poder realizar la implementacion del objeto
    public AdaptadorRecyclerView(ArrayList<String> articulos) {
        this.articulos = articulos;
    }

    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Realizamos el inflate para poder tener la relacion entre la parte de dise;o con la parte logica
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptadorRecyclerView.ViewHolder holder, int position) {
        //Obtenemos el valor que viene y se lo asignamos al metodo respectivo para que lo setee al elemento view
        holder.asignarDatos(articulos.get(position));
    }

    @Override
    public int getItemCount() {
        //Definimos el tama;o que tendra nuestro recyclerview
        return this.articulos.size();
    }

    //Para esta clase nos podemos hacer la idea de que trabaja muy similar a la MainActivity pero no al 100%
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtTextoRecycler);
        }
        //Metodo para poder asignar los valores provenientes del arraylist a nuestros elementos views
        private void asignarDatos(String texto1){
            textView.setText(String.valueOf(texto1));
        }
    }
}
