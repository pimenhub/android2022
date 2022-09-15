package com.jpimentel.myappsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappsw.basededatossw.ClienteDAO;
import com.jpimentel.myappsw.basededatossw.ClienteVO;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MAEliminarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private ListView listView;
    private EditText editTextNom, editTextApe, editTextCorreo, editTextFecha, editTextLimite;
    private Button button;
    ClienteVO cvo = new ClienteVO();
    ClienteDAO cdao = new ClienteDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maeliminar_sw);
        listView = findViewById(R.id.lvListarEliminarClientes);
        editTextNom = findViewById(R.id.edtNombreClienteE);
        editTextApe = findViewById(R.id.edtApellidoClienteE);
        editTextCorreo = findViewById(R.id.edtCorreoClienteE);
        editTextFecha = findViewById(R.id.edtFechaNacimientoClienteE);
        editTextLimite = findViewById(R.id.edtLimiteClienteE);
        button = findViewById(R.id.btnEliminarClienteE);

        cdao.listarMostrarSW(cvo,getApplicationContext(),this, this);
        this.clickEliminar();
    }

    private void clickEliminar() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elimimarCliente();
            }
        });
    }
    private void elimimarCliente(){
        if(!editTextNom.getText().toString().isEmpty() && !editTextApe.getText().toString().isEmpty()
        && !editTextCorreo.getText().toString().isEmpty() && !editTextFecha.getText().toString().isEmpty()
        && !editTextLimite.getText().toString().isEmpty()){
            if(cdao.eliminarSW(cvo,getApplicationContext())){
                editTextNom.setText("");
                editTextApe.setText("");
                editTextCorreo.setText("");
                editTextFecha.setText("");
                editTextLimite.setText("");
                Toast.makeText(this, "Cliente Eliminado Correctamente", Toast.LENGTH_SHORT).show();
                this.recreate();
            }
            else {
                Toast.makeText(this, "Error en la Actualizacion", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> lista = new ArrayList<>();
        if(cdao.respuestaListarMostrar(response) != null){
            if(!cdao.respuestaListarMostrar(response).get(0).getCodCliente().equals(0)) {
                for (ClienteVO cvo : cdao.respuestaListarMostrar(response)) {
                    lista.add(cvo.getNombreCliente());
                }
            }
            else {
                Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
            lista.add("ERROR");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);

        //comportamiento de la lista la pulsar los item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<ClienteVO> llenarEditText = cdao.respuestaListarMostrar(response);
                editTextNom.setText(llenarEditText.get(i).getNombreCliente());
                editTextApe.setText(llenarEditText.get(i).getApellidoCliente());
                editTextCorreo.setText(llenarEditText.get(i).getCorreCliente());

                String fecha = llenarEditText.get(i).getFechaNacimientoCliente();
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = formato.parse(fecha);
                    String fechaFormato = new SimpleDateFormat("dd/MM/yyyy").format(date);
                    editTextFecha.setText(fechaFormato);
                } catch (Exception e) {
                    e.getMessage();
                }

                editTextLimite.setText(String.valueOf(llenarEditText.get(i).getLimiteCreditoCliente()));
                cvo.setCodCliente(llenarEditText.get(i).getCodCliente());
            }
        });


    }
    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }


}