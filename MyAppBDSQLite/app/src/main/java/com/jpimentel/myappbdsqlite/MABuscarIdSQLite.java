package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jpimentel.myappbdsqlite.basededatos.BebidaDAO;
import com.jpimentel.myappbdsqlite.basededatos.BebidaVO;

public class MABuscarIdSQLite extends AppCompatActivity {
    private EditText editTextCodigo;
    private ImageButton imageButton;
    private TextView textViewCodigo, textViewNombre, textViewSabor,
            textViewPresentacion, textViewTipo, textViewPrecio;

    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabuscar_id_sqlite);
        editTextCodigo = findViewById(R.id.edtCodigoBuscar);
        textViewCodigo = findViewById(R.id.txtCodigoBuscar);
        textViewNombre = findViewById(R.id.txtNombreBuscar);
        textViewSabor = findViewById(R.id.txtSaborBuscar);
        textViewPresentacion = findViewById(R.id.txtPresentacionBuscar);
        textViewTipo = findViewById(R.id.txtTipoBuscar);
        textViewPrecio = findViewById(R.id.txtPrecioBuscar);
        imageButton = findViewById(R.id.imgbBuscar);

        this.clickBuscar();
    }

    private void clickBuscar() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarIdBebida();
            }
        });
    }
    private void buscarIdBebida(){
        if(!editTextCodigo.getText().toString().isEmpty()){
            bvo.setCodBebida(Integer.parseInt(editTextCodigo.getText().toString()));
            if(bdao.buscarIdBebida(bvo,getApplicationContext()) != null) {
                if(bdao.buscarIdBebida(bvo,getApplicationContext()).getCount() > 0) {

                    textViewCodigo.setText(String.valueOf("Codigo: "+bvo.getCodBebida()));
                    textViewNombre.setText(String.valueOf("Nombre: "+bvo.getNombreBebida()));
                    textViewSabor.setText(String.valueOf("Sabor: "+bvo.getSaborBebida()));
                    textViewPresentacion.setText(String.valueOf("Presentacion: "+bvo.getPresentacionBebida()+"mL"));
                    textViewTipo.setText(String.valueOf("Tipo: "+bvo.getTipoBebida()));
                    textViewPrecio.setText(String.valueOf("Precio: Q."+bvo.getPrecioBebida()));
                }
                else {
                    textViewCodigo.setText("Codigo:");
                    textViewNombre.setText("Nombre:");
                    textViewSabor.setText("Sabor:");
                    textViewPresentacion.setText("Presentacion:");
                    textViewTipo.setText("Tipo:");
                    textViewPrecio.setText("Precio:");
                    Toast.makeText(getApplicationContext(), "No se encontro Bebida con ese Codigo", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Error en la Busqueda", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}