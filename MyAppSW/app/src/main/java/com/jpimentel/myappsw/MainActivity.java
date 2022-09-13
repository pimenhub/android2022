package com.jpimentel.myappsw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton materialButtonInsertar, materialButtonBuscarCodigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialButtonInsertar = findViewById(R.id.btnmInsertarMenu);
        materialButtonBuscarCodigo = findViewById(R.id.btnmBuscarMenu);

        this.menuSW();
    }

    private void menuSW() {
        materialButtonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInsertarCliente();
            }
        });
        materialButtonBuscarCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            buscarCodigoCliente();
            }
        });
    }
    private void abrirInsertarCliente(){
        Intent intent = new Intent(getApplicationContext(), MAInsertarSW.class);
        startActivity(intent);
    }
    private void buscarCodigoCliente(){
        Intent intent = new Intent(getApplicationContext(), MABuscarIdSW.class);
        startActivity(intent);
    }

}