package com.jpimentel.myapprepaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MASuma extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextN1, editTextN2;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuma);
        editTextN1 = findViewById(R.id.edtN1);
        editTextN2 = findViewById(R.id.edtN2);

        //Forma de interactuar con onClick
        button = findViewById(R.id.btnSumar);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSumar:
                sumar();
                break;
        }
    }
    private void sumar(){
        String n1 = editTextN1.getText().toString();
        String n2 = editTextN2.getText().toString();
        if(!n1.isEmpty() && !n2.isEmpty()){
            int suma = Integer.parseInt(n1) + Integer.parseInt(n2);
            int imgSuma = R.drawable.ic_suma;
            Intent intent = new Intent(this, MAResultados.class);
            intent.putExtra("n1", n1);
            intent.putExtra("n2", n2);
            intent.putExtra("result", suma);
            intent.putExtra("img", imgSuma);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Campos sin datos", Toast.LENGTH_SHORT).show();
        }
    }
}