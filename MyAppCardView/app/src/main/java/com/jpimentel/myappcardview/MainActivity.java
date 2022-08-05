package com.jpimentel.myappcardview;

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
        listView = findViewById(R.id.listCard);

        AdapterLista adapterLista = new AdapterLista(this, R.layout.list_card,saludo());
        listView.setAdapter(adapterLista);

    }
    private ArrayList<String> saludo(){
        ArrayList<String> saludo = new ArrayList<>();
        saludo.add("Hola");
        saludo.add("Adios");
        saludo.add("Buenos dias");
        saludo.add("Buenas noches");
        saludo.add("Buenas tardes");
        return saludo;
    }

}