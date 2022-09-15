package com.jpimentel.myappsw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private MaterialButton materialButtonInsertar, materialButtonBuscarCodigo, materialButtonListarMostrar,
    materialButtonActualizar, materialButtonEliminar;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialButtonInsertar = findViewById(R.id.btnmInsertarMenu);
        materialButtonBuscarCodigo = findViewById(R.id.btnmBuscarMenu);
        materialButtonListarMostrar = findViewById(R.id.btnmListarMenu);
        materialButtonActualizar = findViewById(R.id.btnmActualizarMenu);
        materialButtonEliminar = findViewById(R.id.btnmEliminarMenu);
        floatingActionButton = findViewById(R.id.floating_action_button);
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
        materialButtonListarMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listarMostrarCliente();
            }
        });
        materialButtonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActualizar();
            }
        });
        materialButtonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirEliminar();
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensajeEnBarra(view);
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
    private void listarMostrarCliente(){
        Intent intent = new Intent(getApplicationContext(), MAListarMostrarSW.class);
        startActivity(intent);
    }
    private void abrirActualizar(){
        Intent intent = new Intent(getApplicationContext(), MAActualizarSW.class);
        startActivity(intent);
    }
    private void abrirEliminar(){
        Intent intent = new Intent(getApplicationContext(), MAEliminarSW.class);
        startActivity(intent);
    }
    private void mensajeEnBarra(View view){
        Snackbar snackbar = Snackbar.make(view, "Servicio Web con Android, PHP y MySQL", Snackbar.LENGTH_SHORT);
        //Hacer que aparezca arriba del componente parámetro
        //snackbar.setAnchorView(floatingActionButton);
        //Establecer el tiempo que será visible
        snackbar.setDuration(5000);
        //Agregar animación
        snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
        snackbar.show();
    }

}