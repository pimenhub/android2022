package com.jpimentel.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables globales que representaran a los elementos o views
    private TextView textViewContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Establecer las view que se van a utilizar identificandolas por medio de su ID
        textViewContador = findViewById(R.id.txtContador);

    }
    private void mas(){
       this.contador++;
       this.textViewContador.setText(String.valueOf(contador));
    }
    private void menos(){
        this.contador--;
        this.textViewContador.setText(String.valueOf(contador));
    }
    private void reiniciar(){
        this.contador = 0;
        this.textViewContador.setText(String.valueOf(contador));
        if(contador == 0)
            Toast.makeText(this, "El Contador se Reinicio a 0", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        if(view.getId() == R.id.btnMas){
            this.mas();
            //Toast.makeText(this, "Estoy Sumando", Toast.LENGTH_SHORT).show();
        }
        if(view.getId() == R.id.btnMenos){
            this.menos();
            //Toast.makeText(this, "Estoy Restando", Toast.LENGTH_SHORT).show();
        }
        if(view.getId() == R.id.btnReiniciar){
            this.reiniciar();
        }
    }
}