package com.example.adriel.cadastro.Atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.adriel.cadastro.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsuario, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

    }

    public void logar(View view){
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        boolean validacao = true;

        if (usuario == null || usuario.equals("")){
            validacao = false;
            edtUsuario.setError(getString(R.string.login_txtUsuario));
        }

        if (senha == null || usuario.equals("")){
            validacao = false;
            edtSenha.setError(getString(R.string.login_valSenha));
        }

        if(validacao){

        }
    }

}
