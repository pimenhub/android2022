package com.jpimentel.myappmultiplesactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnSiguienteR);

        this.click();
    }

    private void click() {
        int a = 2;
        Intent intent = new Intent(this, MainActivity3.class);
        Intent intent2 = new Intent(this, MainActivity2.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 2){
                    startActivity(intent);
                }
                else if(a == 1){
                    startActivity(intent2);
                }

                //finish();
            }
        });

    }
}