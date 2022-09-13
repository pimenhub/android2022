package com.jpimentel.myappsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappsw.basededatossw.ClienteDAO;
import com.jpimentel.myappsw.basededatossw.ClienteVO;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MABuscarIdSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private EditText editTextCodigo;
    private TextView textViewCod, textViewNom, textViewApe, textViewCorreo, textViewFecha, textViewLimite;
    private ImageButton imageButton;

    ClienteDAO cdao = new ClienteDAO();
    ClienteVO cvo = new ClienteVO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabuscar_id_sw);
        editTextCodigo = findViewById(R.id.edtCodigoClienteBuscar);
        textViewCod = findViewById(R.id.txtCodigoBuscar);
        textViewNom = findViewById(R.id.txtNombreBuscar);
        textViewApe = findViewById(R.id.txtApellidoBuscar);
        textViewCorreo = findViewById(R.id.txtCorreoBuscar);
        textViewFecha = findViewById(R.id.txtFechaNaBuscar);
        textViewLimite = findViewById(R.id.txtLimiteBuscar);
        imageButton = findViewById(R.id.imbBuscar);
        this.clickBuscar();

    }

    private void clickBuscar() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarClientePorCodigo();
            }
        });
    }

    private void buscarClientePorCodigo() {
        if (!editTextCodigo.getText().toString().isEmpty()) {
            cvo.setCodCliente(Integer.parseInt(editTextCodigo.getText().toString()));
            if (!cdao.buscarIdSW(cvo, getApplicationContext(), this, this)) {
                textViewCod.setText("Codigo:");
                textViewNom.setText("Nombre:");
                textViewApe.setText("Apellido:");
                textViewCorreo.setText("Correo:");
                textViewFecha.setText("Fecha de Nacimiento");
                textViewLimite.setText("Limite de Credito:");
                Toast.makeText(this, "Error en la comunicacion con el servidor de la informacion", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Debe de llenar el campo a buscar", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {

        if(cdao.respuestaBusquedaID(cvo,response)) {
            textViewCod.setText("Codigo: " + cvo.getCodCliente());
            textViewNom.setText("Nombre: " + cvo.getNombreCliente());
            textViewApe.setText("Apellido: " + cvo.getApellidoCliente());
            textViewCorreo.setText("Correo: " + cvo.getCorreCliente());
            String fecha = cvo.getFechaNacimientoCliente();
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = formato.parse(fecha);
                String fechaFormato = new SimpleDateFormat("dd/MM/yyyy").format(date);
                textViewFecha.setText("Fecha de Nacimiento: " + fechaFormato);
            } catch (Exception e) {
                e.getMessage();
            }
            textViewLimite.setText("Limite de Credito: Q." + cvo.getLimiteCreditoCliente());
        }
        else {
            textViewCod.setText("Codigo:");
            textViewNom.setText("Nombre:");
            textViewApe.setText("Apellido:");
            textViewCorreo.setText("Correo:");
            textViewFecha.setText("Fecha de Nacimiento");
            textViewLimite.setText("Limite de Credito:");
            Toast.makeText(this, "Datos No Encontrados", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }
}