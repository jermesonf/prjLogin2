package com.example.prjaulalogin2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class Inserir extends AppCompatActivity {

    EditText usu, sen;
    Acessa objA = new Acessa();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        usu = findViewById(R.id.tNomeInserir);
        sen = findViewById(R.id.tSenhaInserir);

    }

    public void salvar(View v)
    {
        String nome = usu.getText().toString();
        String senha = sen.getText().toString();
        objA.entBanco(this);

        try{
            int res = objA.stmt.executeUpdate("INSERT INTO login(usuario,senha) VALUES ('"+nome+"','"+senha+"')");

            //Se o objA ir para o proximo item do banco
            if(res != 0)
            {
                Toast.makeText(getApplicationContext(),"Dado Salvo", Toast.LENGTH_SHORT).show();

                usu.setText("");
                sen.setText("");
                usu.requestFocus();

            }//fim if
            else
            {
                Toast.makeText(getApplicationContext(),"Dados não Salvo", Toast.LENGTH_SHORT).show();
            }//fim else

        }//fim try
        catch (SQLException ex)
        {
            Toast.makeText(getApplicationContext(), "erro" + ex, Toast.LENGTH_SHORT).show();
        }//fim catch

    }

}