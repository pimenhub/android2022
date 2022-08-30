package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
        listView.setAdapter(arrayAdapter);


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
}