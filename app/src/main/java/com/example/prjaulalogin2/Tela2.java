package com.example.prjaulalogin2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    public void inserir(View v)
    {
        Intent troca = new Intent(Tela2.this, Inserir.class);
        startActivity(troca);
        finish();
    }

    public void sair(View v)
    {
        finish();
    }



}