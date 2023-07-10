package com.karol.tcc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class telaCadastro extends AppCompatActivity {

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);


    }

    public void Cadastrar(View view) {
        EditText nome =(EditText) findViewById(R.id.nome);
        EditText email1 =(EditText) findViewById(R.id.email1);
        EditText email2 =(EditText) findViewById(R.id.email2);
        EditText senha1 =(EditText) findViewById(R.id.senha1);
        EditText senha2 =(EditText) findViewById(R.id.senha2);


        String nomeText = nome.getText().toString();
        String email1Text = email1.getText().toString();
        String email2Text = email2.getText().toString();
        String senha1Text = senha1.getText().toString();
        String senha2Text = senha2.getText().toString();

        if (TextUtils.isEmpty(nomeText) || TextUtils.isEmpty(email1Text) ||
                TextUtils.isEmpty(email2Text) || TextUtils.isEmpty(senha1Text) ||
                TextUtils.isEmpty(senha2Text)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(telaCadastro.this);
                    builder.setMessage("Preencha todos os campos!");
                    builder.create().show();
                }
            });

        } else if (!email1Text.equals(email2Text) || !senha1Text.equals(senha2Text)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(telaCadastro.this);
                    builder.setMessage("Os campos de email ou/e senha não coincidem!");
                    builder.create().show();
                }
            });
        } else {
            Usuario usuario = new Usuario();
            usuario.nome = nomeText;
            usuario.email = email2Text;
            usuario.senha = senha2Text;

            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "TCC").build();
                        UsuarioDAO dao = db.usuarioDao();
                        dao.insertAll(usuario);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                AlertDialog.Builder builder = new AlertDialog.Builder(telaCadastro.this);
                                builder.setMessage("Salvo com sucesso " + usuario.nome);
                                alertDialog = builder.create();
                                alertDialog.show();

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        alertDialog.dismiss();
                                        Intent intent = new Intent(telaCadastro.this, telaLogin.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}