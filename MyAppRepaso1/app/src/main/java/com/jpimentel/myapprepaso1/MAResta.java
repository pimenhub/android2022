package com.jpimentel.myapprepaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MAResta extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextN1, editTextN2;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maresta);
        editTextN1 = findViewById(R.id.edtN1R);
        editTextN2 = findViewById(R.id.edtN2R);

        button = findViewById(R.id.btnRestar);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        resta();
    }
    private void resta(){
        String n1 = editTextN1.getText().toString();
        String n2 = editTextN2.getText().toString();
        if(!n1.isEmpty() && !n2.isEmpty()){
            int resta = Integer.parseInt(n1) - Integer.parseInt(n2);
            int img = R.drawable.ic_resta;
            Intent intent = new Intent(this, MAResultados.class);
            intent.putExtra("n1", n1);
            intent.putExtra("n2", n2);
            intent.putExtra("result", resta);
            intent.putExtra("img", img);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Campos sin datos", Toast.LENGTH_SHORT).show();
        }
    }
}