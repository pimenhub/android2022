package com.jpimentel.myapprepaso2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvGenerosMusicales);

        AdapterLista adapterLista = new AdapterLista(this,R.layout.lista_personalizada,
                this.generosMusicales(),this.imgGenerosMusicales());
        listView.setAdapter(adapterLista);
    }
    private ArrayList<String> generosMusicales(){
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Rock");
        generos.add("Jazz");

        return generos;
    }

    private ArrayList<Integer> imgGenerosMusicales(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.mipmap.ic_launcher);
        img.add(R.mipmap.ic_launcher);

        return img;
    }
}