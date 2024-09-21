package com.example.prjaulalogin2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText tUsua, tSenha;

    //Instanciando a classe Acessa
    Acessa objA = new Acessa();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        tUsua = findViewById(R.id.tNome);
        tSenha = findViewById(R.id.tSenha);

    }//Fim onCreate

    public void entrar(View v){
        objA.entBanco(this);
        String nome = tUsua.getText().toString();
        String senha = tSenha.getText().toString();

        try{
            //stmt = tradutor
            objA.RS = objA.stmt.executeQuery("SELECT * FROM login WHERE usuario='"+nome+"'AND senha='"+senha+"'");

            //Se o objA ir para o proximo item do banco
            if(objA.RS.next())
            {
                Toast.makeText(getApplicationContext(),"Aprovado", Toast.LENGTH_SHORT).show();

                //Mude da tela principal para a Tela2
                Intent intent = new Intent(MainActivity.this, Tela2.class);
                //Incie essa intenção
                startActivity(intent);
                //Feche a tela principal apos iniciar a tela2
                finish();
            }//fim if
            else
            {
                Toast.makeText(getApplicationContext(),"Entrada não aprovada", Toast.LENGTH_SHORT).show();
            }//fim else

        }//fim try
        catch (SQLException ex)
        {
                Toast.makeText(getApplicationContext(), "erro no acesso", Toast.LENGTH_SHORT).show();
        }//fim catch

    }

}//Fim Main