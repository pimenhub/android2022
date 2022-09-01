package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonInsertar, buttonBuscar, buttonListar, buttonActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonInsertar = findViewById(R.id.btnInsertarMenu);
        buttonBuscar = findViewById(R.id.btnBuscarMenu);
        buttonListar = findViewById(R.id.btnListarMenu);
        buttonActualizar = findViewById(R.id.btnActualizarMenu);
        this.navegacionMenu();
    }
    private void navegacionMenu(){
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInsertar();
            }
        });
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirBuscar();
            }
        });
        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirListadoBebidas();
            }
        });
        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActualizar();
            }
        });
    }
    private void abrirInsertar(){
        Intent intent = new Intent(this,MAInsertarSQLite.class);
        startActivity(intent);
    }
    private void abrirBuscar(){
        Intent intent = new Intent(this,MABuscarIdSQLite.class);
        startActivity(intent);
    }
    private void abrirListadoBebidas(){
        Intent intent = new Intent(this,MAListarMostrarSQLite.class);
        startActivity(intent);
    }
    private void abrirActualizar(){
        Intent intent = new Intent(this,MAActualizarSQLite.class);
        startActivity(intent);
    }
}