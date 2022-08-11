package com.jpimentel.myapplistapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MADatosAdicionales extends AppCompatActivity {
    private TextView textViewNom, textViewApe, textViewEd, textViewEs;
    private ImageView imageView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madatos_adicionales);
        textViewNom = findViewById(R.id.txtNombreDatoAdicional);
        textViewApe = findViewById(R.id.txtApellidoDatoAdicional);
        textViewEd = findViewById(R.id.txtEdadDatoAdicional);
        textViewEs = findViewById(R.id.txtEstadoDatoAdicional);
        imageView = findViewById(R.id.imgUserDatosAdicionales);
        button = findViewById(R.id.btnCancelar);

        this.obtener();
        this.click();
    }

    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        Integer img = bundle.getInt("img");
        String nombre = bundle.getString("nombre");
        String apellido = bundle.getString("apellido");
        Integer edad = bundle.getInt("edad");
        String estado = bundle.getString("estado");
        //----------------------------------------------
        imageView.setImageResource(img);
        textViewNom.setText(String.valueOf(nombre));
        textViewApe.setText(String.valueOf(apellido));
        textViewEd.setText(String.valueOf(edad));
        textViewEs.setText(String.valueOf(estado));
    }
    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });
    }
    private void regresar(){
        Intent intent = new Intent(this, MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//Finaliza todas las actividades excepto hacia donde apunta el intent
        startActivity(intent);
        finish();
    }

}