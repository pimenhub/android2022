package com.jpimentel.myappnombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombre);
        textViewResultado = findViewById(R.id.txtResultado);
        editTextEdad = findViewById(R.id.edtEdad);

    }

    private void mostrar(){
        String nombre = editTextNombre.getText().toString();
        String edad = editTextEdad.getText().toString();
        if(!nombre.isEmpty() && !edad.isEmpty()){
            Calendar c = Calendar.getInstance();
            int anacimiento =  c.get(Calendar.YEAR) - Integer.parseInt(edad);
            textViewResultado.setText("Su nombre es: "+nombre+" y su anio de nacimiento es: "+anacimiento);
        }
        else {
            Toast.makeText(this, "Dato no Ingresado", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
                this.mostrar();
                break;
        }
    }
}