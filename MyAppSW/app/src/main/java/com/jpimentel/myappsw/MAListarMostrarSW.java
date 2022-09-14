package com.jpimentel.myappsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappsw.basededatossw.ClienteDAO;
import com.jpimentel.myappsw.basededatossw.ClienteVO;

import org.json.JSONObject;

import java.util.ArrayList;

public class MAListarMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private ListView listView;
    private ClienteVO cvo = new ClienteVO();
    private ClienteDAO cdao = new ClienteDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malistar_mostrar_sw);
        listView = findViewById(R.id.lvListarClientes);

        cdao.listarMostrarSW(cvo, getApplicationContext(),this, this);
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> lista = new ArrayList<>();
        if(cdao.respuestaListarMostrar(response) != null) {
            for (ClienteVO clienteVO : cdao.respuestaListarMostrar(response)) {
                lista.add(clienteVO.getNombreCliente());
            }
        }
        else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
            lista.add("ERROR");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }

}