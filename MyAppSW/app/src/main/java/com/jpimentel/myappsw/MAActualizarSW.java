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

public class MAActualizarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private ListView listView;
    private EditText editTextNombre, editTextApellido, editTextCorreo,
            editTextFecha, editTextLimite;
    private Button button;
    ClienteVO cvo = new ClienteVO();
    ClienteDAO cdao = new ClienteDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maactualizar_sw);
        listView = findViewById(R.id.lvListarActualizarClientes);
        editTextNombre = findViewById(R.id.edtNombreCliente);
        editTextApellido = findViewById(R.id.edtApellidoCliente);
        editTextCorreo = findViewById(R.id.edtCorreoCliente);
        editTextFecha = findViewById(R.id.edtFechaNacimientoCliente);
        editTextLimite = findViewById(R.id.edtLimiteCliente);
        button = findViewById(R.id.btnActualizarCliente);

        cdao.listarMostrarSW(cvo, getApplicationContext(), this, this);
        this.clickActualizar();
    }

    private void clickActualizar() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarCliente();
            }
        });
    }

    private void actualizarCliente() {
        if (!editTextNombre.getText().toString().isEmpty() && !editTextApellido.getText().toString().isEmpty() &&
                !editTextCorreo.getText().toString().isEmpty() && !editTextFecha.getText().toString().isEmpty() &&
                !editTextLimite.getText().toString().isEmpty()) {
            cvo.setNombreCliente(editTextNombre.getText().toString());
            cvo.setApellidoCliente(editTextApellido.getText().toString());
            cvo.setCorreCliente(editTextCorreo.getText().toString());

            String fecha = editTextFecha.getText().toString();
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = formato.parse(fecha);
                String fechaFormato = new SimpleDateFormat("yyyy/MM/dd").format(date);
                cvo.setFechaNacimientoCliente(fechaFormato);
            } catch (Exception e) {
                e.getMessage();
            }
            cvo.setLimiteCreditoCliente(Double.parseDouble(editTextLimite.getText().toString()));

            if (cdao.actualizarSW(cvo, getApplicationContext())) {
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextCorreo.setText("");
                editTextFecha.setText("");
                editTextLimite.setText("");
                Toast.makeText(this, "Cliente Actualizado Correctamente", Toast.LENGTH_SHORT).show();
                this.recreate();
            } else {
                Toast.makeText(this, "Error en la Actualizacion", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debe de llenar todos los campos para poder actualizar", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> lista = new ArrayList<>();
        if (cdao.respuestaListarMostrar(response) != null) {
            if (!cdao.respuestaListarMostrar(response).get(0).getCodCliente().equals(0)) {
                for (ClienteVO clienteVO : cdao.respuestaListarMostrar(response)) {
                    lista.add(clienteVO.getNombreCliente());
                }
            } else {
                Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
                button.setEnabled(false);
            }
        } else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
            lista.add("ERROR");
        }
        //Llenado de la lista a visualizar
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);

        //Llenado de los Edit Text de forma visual que seran los datos a actualizar
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<ClienteVO> setearEditText = cdao.respuestaListarMostrar(response);
                editTextNombre.setText(setearEditText.get(i).getNombreCliente());
                editTextApellido.setText(setearEditText.get(i).getApellidoCliente());
                editTextCorreo.setText(setearEditText.get(i).getCorreCliente());

                String fecha = setearEditText.get(i).getFechaNacimientoCliente();
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = formato.parse(fecha);
                    String fechaFormato = new SimpleDateFormat("dd/MM/yyyy").format(date);
                    editTextFecha.setText(fechaFormato);
                } catch (Exception e) {
                    e.getMessage();
                }
                editTextLimite.setText(String.valueOf(setearEditText.get(i).getLimiteCreditoCliente()));
                cvo.setCodCliente(setearEditText.get(i).getCodCliente());
            }
        });
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }
}