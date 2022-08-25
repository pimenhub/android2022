package com.jpimentel.myappsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre, editTextEdad;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombreSP);
        editTextEdad = findViewById(R.id.edtEdadSP);
        button = findViewById(R.id.btnAlmacenarSP);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                almacenarDatos();
            }
        });
        this.obtenerDatos();
    }
    private void almacenarDatos(){
        if(!editTextNombre.getText().toString().isEmpty() && !editTextEdad.getText().toString().isEmpty()){
            //Instanciar la clase SharedPreference para utilizar su objeto, ya que es el que me permitira
            //realizar la accion de almacenado
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);

            String nombre = editTextNombre.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());

            //Almancenar los datos que se encuentran en las variables
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre",nombre);
            editor.putInt("edad", edad);
            if(editor.commit() == true){
                editTextNombre.setText("");
                editTextEdad.setText("");
                Toast.makeText(this, "Datos Almacenados Correctamente", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Almacenamiento de los Datos", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
        //Se asingan los datos que estan almacenados en el preference
        //Luego definimos valores por defecto ya que el archivo puede estar vacio
        String nombre = preferences.getString("nombre","");
        int edad = preferences.getInt("edad",0);
        if(edad == 0) {
            editTextEdad.setText("");
        }
        else {
            editTextEdad.setText(String.valueOf(edad));
        }
        editTextNombre.setText(String.valueOf(nombre));

    }
}