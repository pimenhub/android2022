package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jpimentel.myappbdsqlite.basededatos.BebidaDAO;
import com.jpimentel.myappbdsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public class MAListarMostrarSQLite extends AppCompatActivity {
    private ListView listView;
    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malistar_mostrar_sqlite);
        listView = findViewById(R.id.lvListadoBebidas);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,llenarLista());
        this.clickItemLista();
        listView.setAdapter(arrayAdapter);

    }
    private void clickItemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                trasladarDatos(i,MADetalle.class);
            }
        });
    }

    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarBebida(bvo,getApplicationContext()) != null) {
            for (BebidaVO listaVO : bdao.listarBebida(bvo, getApplicationContext())) {
                lista.add(listaVO.getNombreBebida());
            }
        }
        return lista;
    }

    private void trasladarDatos(int position, Class actividad){
        Intent intent = new Intent(this, actividad);
        intent.putExtra("codigo", bdao.listarBebida(bvo,getApplicationContext()).get(position).getCodBebida().toString());
        intent.putExtra("nombre", bdao.listarBebida(bvo,getApplicationContext()).get(position).getNombreBebida());
        intent.putExtra("sabor", bdao.listarBebida(bvo,getApplicationContext()).get(position).getSaborBebida());
        intent.putExtra("presentacion", bdao.listarBebida(bvo,getApplicationContext()).get(position).getPresentacionBebida().toString());
        intent.putExtra("tipo", bdao.listarBebida(bvo,getApplicationContext()).get(position).getTipoBebida());
        intent.putExtra("precio", bdao.listarBebida(bvo,getApplicationContext()).get(position).getPrecioBebida().toString());
        startActivity(intent);
    }
}