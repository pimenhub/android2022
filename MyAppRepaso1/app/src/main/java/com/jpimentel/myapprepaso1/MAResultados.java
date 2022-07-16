package com.jpimentel.myapprepaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MAResultados extends AppCompatActivity {
    private TextView textViewN1, textViewN2, textViewResultado;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maresultados);
        textViewN1 = findViewById(R.id.txtN1Result);
        textViewN2 = findViewById(R.id.txtN2Result);
        textViewResultado = findViewById(R.id.txtResultadoFinal);
        imageView = findViewById(R.id.imgResult);

        this.obtener();
    }

    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        String n1 = bundle.getString("n1");
        String n2 = bundle.getString("n2");
        int resultado = bundle.getInt("result");
        int img = bundle.getInt("img");

        textViewN1.setText(n1);
        textViewN2.setText(n2);
        textViewResultado.setText(String.valueOf(resultado));
        imageView.setImageResource(img);
    }


}