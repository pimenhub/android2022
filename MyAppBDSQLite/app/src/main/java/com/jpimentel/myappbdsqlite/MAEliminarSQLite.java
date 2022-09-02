package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jpimentel.myappbdsqlite.basededatos.BebidaDAO;
import com.jpimentel.myappbdsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public class MAEliminarSQLite extends AppCompatActivity {
    private ListView listView;
    private EditText editTextNombre;
    private Button button;
    private BebidaVO bvo = new BebidaVO();
    private BebidaDAO bdao = new BebidaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maeliminar_sqlite);
        listView = findViewById(R.id.lvBebidasEliminar);
        editTextNombre = findViewById(R.id.edtNombreBebidaEliminar);
        button = findViewById(R.id.btnEliminarRegistro);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarLista());
        this.clickItemLista();
        listView.setAdapter(arrayAdapter);
        this.clickEliminar();
    }
    private void clickItemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                llenarEditTextNombre(i);
            }
        });
    }

    private void clickEliminar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarRegistro();
            }
        });
    }

    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarBebida(bvo,getApplicationContext()) != null) {
            for (BebidaVO vo : bdao.listarBebida(bvo, getApplicationContext())) {
                lista.add(vo.getCodBebida() + ". " + vo.getNombreBebida());
            }
        }
        return lista;
    }

    private void llenarEditTextNombre(int position){
        ArrayList<BebidaVO> datoEliminar = bdao.listarBebida(bvo,getApplicationContext());
        editTextNombre.setText(datoEliminar.get(position).getNombreBebida());
        bvo.setCodBebida(datoEliminar.get(position).getCodBebida());
    }

    private void eliminarRegistro(){
        if(!editTextNombre.getText().toString().isEmpty()){
            if(bdao.eliminarBebida(bvo,getApplicationContext())){
                editTextNombre.setText("");

                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarLista());
                listView.setAdapter(arrayAdapter);

                Toast.makeText(this, "Bebida Eliminada Correctamente", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Error en la Eliminacion", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe de eligir una Bebida para poder Eliminarla", Toast.LENGTH_SHORT).show();
        }
    }
}