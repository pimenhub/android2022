package com.jpimentel.myappsw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class MAListarMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private ListView listView;
    private ClienteVO cvo = new ClienteVO();
    private ClienteDAO cdao = new ClienteDAO();
    AlertDialog.Builder informacionAlerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malistar_mostrar_sw);
        listView = findViewById(R.id.lvListarClientes);
        //alertDialog
        informacionAlerta = new AlertDialog.Builder(this);

        cdao.listarMostrarSW(cvo, getApplicationContext(), this, this);
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> lista = new ArrayList<>();
        if (cdao.respuestaListarMostrar(response) != null) {
            if(!cdao.respuestaListarMostrar(response).get(0).getCodCliente().equals(0)) {
                for (ClienteVO clienteVO : cdao.respuestaListarMostrar(response)) {
                    lista.add(clienteVO.getCodCliente() + ". " + clienteVO.getNombreCliente());
                }
            }
            else {
                Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Error, no existen datos", Toast.LENGTH_SHORT).show();
            lista.add("ERROR");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<ClienteVO> llenarAlertDialog = cdao.respuestaListarMostrar(response);
                String fechaMostrar = "";
                String fecha = llenarAlertDialog.get(i).getFechaNacimientoCliente();
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = formato.parse(fecha);
                    String fechaFormato = new SimpleDateFormat("dd/MM/yyyy").format(date);
                    fechaMostrar = fechaFormato;
                } catch (Exception e) {
                    e.getMessage();
                }

                informacionAlerta.setTitle("Informacion del Cliente");
                informacionAlerta.setMessage("Codigo del Cliente: " + llenarAlertDialog.get(i).getCodCliente() + "\n" +
                        "Nombre del Cliente: " + llenarAlertDialog.get(i).getNombreCliente() + "\n" +
                        "Apellido del Cliente: " + llenarAlertDialog.get(i).getApellidoCliente() + "\n" +
                        "Correo del Cliente: " + llenarAlertDialog.get(i).getCorreCliente() + "\n" +
                        "Fecha de Nacimiento del Cliente: " + fechaMostrar + "\n" +
                        "Limite de Credito del Cliente: Q." + llenarAlertDialog.get(i).getLimiteCreditoCliente());
                informacionAlerta.setPositiveButton("Aceptar", null);
                AlertDialog dialog = informacionAlerta.create();
                dialog.show();
            }
        });
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }

}