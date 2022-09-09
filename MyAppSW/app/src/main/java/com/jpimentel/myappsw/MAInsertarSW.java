package com.jpimentel.myappsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.jpimentel.myappsw.basededatossw.ClienteDAO;
import com.jpimentel.myappsw.basededatossw.ClienteVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MAInsertarSW extends AppCompatActivity {
    private TextInputEditText editTextNombre, editTextApellido, editTextCorreo, editTextFechaNacimiento, editTextLiminteCredito;
    private MaterialButton button;

    ClienteVO cvo = new ClienteVO();
    ClienteDAO cdao = new ClienteDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsertar_sw);
        editTextNombre = findViewById(R.id.tfmNombreInsertar);
        editTextApellido = findViewById(R.id.tfmApellidoInsertar);
        editTextCorreo = findViewById(R.id.tfmCorreoInsertar);
        editTextFechaNacimiento = findViewById(R.id.tfmFechaNaInsertar);
        editTextLiminteCredito = findViewById(R.id.tfmLimiteCreInsertar);
        button = findViewById(R.id.btnmInsertarCliente);

        this.clickRegistrar();

    }

    private void clickRegistrar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCliente();
            }
        });
    }
    private void registrarCliente() {
        //Condicion de campos edittext
        if(!editTextNombre.getText().toString().isEmpty() && !editTextApellido.getText().toString().isEmpty() &&
        !editTextCorreo.getText().toString().isEmpty() && !editTextFechaNacimiento.getText().toString().isEmpty() &&
        !editTextLiminteCredito.getText().toString().isEmpty()){
            //llenado de variables VO por medio de set
            cvo.setNombreCliente(editTextNombre.getText().toString());
            cvo.setApellidoCliente(editTextApellido.getText().toString());
            cvo.setCorreCliente(editTextCorreo.getText().toString());
            String fecha = editTextFechaNacimiento.getText().toString();
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = formato.parse(fecha);
                String fechaFormato = new SimpleDateFormat("yyyy/MM/dd").format(date);
                cvo.setFechaNacimientoCliente(fechaFormato);
            } catch (Exception e) {
                e.getMessage();
            }
            cvo.setLimiteCreditoCliente(Double.parseDouble(editTextLiminteCredito.getText().toString()));

            if(cdao.insertarSW(cvo,getApplicationContext())){
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextCorreo.setText("");
                editTextFechaNacimiento.setText("");
                editTextLiminteCredito.setText("");
                Toast.makeText(this, "Cliente Registrado Correctamente", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Error en el Registro", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}