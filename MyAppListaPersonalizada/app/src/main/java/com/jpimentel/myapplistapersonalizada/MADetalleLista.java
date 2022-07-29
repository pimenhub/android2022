package com.jpimentel.myapplistapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MADetalleLista extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madetalle_lista);
        listView = findViewById(R.id.listDetalle);

        obtenerDatos();
        llenarLista();
    }

    private String obtenerDatos() {
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        return nombre;
    }

    private void llenarLista() {
        AdapterPersonalizadoSecundario secundario;
        switch (obtenerDatos()) {
            case "Pedro":
                secundario = new AdapterPersonalizadoSecundario(this, R.layout.lista_personalizada_secundaria,
                        imagesPedro(), nombreFamiliarPedro(), apellidoFamiliarPedro(), edadFamiliarPedro());
                listView.setAdapter(secundario);
                break;
            case "Karla":
                secundario = new AdapterPersonalizadoSecundario(this, R.layout.lista_personalizada_secundaria,
                        imagesKarla(), nombreFamiliarKarla(), apellidoFamiliarKarla(), edadFamiliarKarla());
                listView.setAdapter(secundario);
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private ArrayList<Integer> imagesPedro() {
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        return images;
    }

    private ArrayList<String> nombreFamiliarPedro() {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Julio");
        nombres.add("Erick");
        nombres.add("Rosa");
        return nombres;
    }

    private ArrayList<String> apellidoFamiliarPedro() {
        ArrayList<String> apellidos = new ArrayList<>();
        apellidos.add("Perez");
        apellidos.add("Perez");
        apellidos.add("Perez");
        return apellidos;
    }

    private ArrayList<Integer> edadFamiliarPedro() {
        ArrayList<Integer> edad = new ArrayList<>();
        edad.add(25);
        edad.add(18);
        edad.add(30);
        return edad;
    }

    private ArrayList<Integer> imagesKarla() {
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.ic_user);
        images.add(R.drawable.ic_user);
        images.add(R.drawable.ic_user);
        return images;
    }

    private ArrayList<String> nombreFamiliarKarla() {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Brian");
        nombres.add("Glenda");
        nombres.add("Pablo");
        return nombres;
    }

    private ArrayList<String> apellidoFamiliarKarla() {
        ArrayList<String> apellidos = new ArrayList<>();
        apellidos.add("Ruiz");
        apellidos.add("Ruiz");
        apellidos.add("Ruiz");
        return apellidos;
    }

    private ArrayList<Integer> edadFamiliarKarla() {
        ArrayList<Integer> edad = new ArrayList<>();
        edad.add(32);
        edad.add(15);
        edad.add(20);
        return edad;
    }
}