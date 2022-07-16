package com.jpimentel.myapprepaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonS, buttonR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonS = findViewById(R.id.btnConoceSuma);
        buttonR = findViewById(R.id.btnConoceResta);
        this.click();
        this.clickR();
    }

    private void click() {
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aperturaSuma();
            }
        });
    }
    private void clickR() {
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aperturarResta();
            }
        });
    }
    private void aperturaSuma(){
        Intent intent = new Intent(this,MASuma.class);
        startActivity(intent);
    }
    private void aperturarResta(){
        Intent intent = new Intent(this, MAResta.class);
        startActivity(intent);
    }
}