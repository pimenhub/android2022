package com.jpimentel.myapplistapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listUser);

        AdapterPersonalizadoPrincipal principal = new AdapterPersonalizadoPrincipal(getApplicationContext(), R.layout.lista_personalizada_principal, images(), nombres());
        listView.setAdapter(principal);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    traslado1(i);
            }
        });

    }

    private ArrayList<Integer> images(){
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.ic_user);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_user);
        images.add(R.drawable.ic_launcher_foreground);
        return images;
    }
    private ArrayList<String> nombres(){
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Pedro");
        nombres.add("Karla");
        nombres.add("Enrique");
        nombres.add("Andrea");
        return nombres;
    }

    private void traslado1(int position){
        Intent intent = new Intent(getApplicationContext(),MADetalleLista.class);
        intent.putExtra("nombre", nombres().get(position));
        startActivity(intent);
    }
}