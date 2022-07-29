package com.jpimentel.myappgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridAnimalesDomes);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.animales());
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "A pulsado "+animales().get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList<String> animales(){
        ArrayList<String> animales = new ArrayList<>();
        animales.add("Perro");
        animales.add("Gato");
        animales.add("Hamster");
        animales.add("Loro");
        animales.add("Tortuga");
        animales.add("Perico");

        animales.add("Perro");
        animales.add("Gato");
        animales.add("Hamster");
        animales.add("Loro");
        animales.add("Tortuga");
        animales.add("Perico");

        animales.add("Perro");
        animales.add("Gato");
        animales.add("Hamster");
        animales.add("Loro");
        animales.add("Tortuga");
        animales.add("Perico");

        animales.add("Perro");
        animales.add("Gato");
        animales.add("Hamster");
        animales.add("Loro");
        animales.add("Tortuga");
        animales.add("Perico");
        return animales;
    }
}