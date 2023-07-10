package com.karol.tcc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

public class telaLogin extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);


        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(telaLogin.this, telaCadastro.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);

    }

    public void Login(View view) {
        EditText email = findViewById(R.id.edit_email);
        EditText senha = findViewById(R.id.edit_senha);

        String emailText = email.getText().toString();
        String senhaText = senha.getText().toString();

        if (emailText.equals("adm") && senhaText.equals("adm")) {
            // Usuário e senha são "adm", redirecionar para a tela de cadastro de academias
            Intent intent = new Intent(telaLogin.this, telaAdm.class);
            startActivity(intent);
            finish();

        } else {
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "TCC").build();
                        UsuarioDAO dao = db.usuarioDao();

                        Usuario usuario = dao.findByName(email.getText().toString(), senha.getText().toString());


                        if (usuario != null) {

                            if (usuario.getEmail() != null && !usuario.getEmail().isEmpty()
                                    && usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
                                // Usuário encontrado, realizar ação necessária
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        // Limpar os campos
                                        email.setText("");
                                        senha.setText("");

                                        AlertDialog.Builder builder = new AlertDialog.Builder(telaLogin.this);
                                        builder.setMessage("Bem-vindo(a,e) ao Gym Now " + usuario.getNome() + "!");  // exibir o nome do usuário
                                        alertDialog = builder.create();
                                        alertDialog.show();

                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                // Fechar o AlertDialog antes de iniciar a próxima atividade
                                                alertDialog.dismiss();

                                                // Iniciar a próxima atividade após o atraso
                                                Intent intent = new Intent(telaLogin.this, telaPesquisa.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }, 1500); // Tempo em milissegundos (aqui definido como 1,5 segundo)


                                    }
                                });

                                // Iniciar a próxima atividade
                                //Intent intent = new Intent(telaLogin.this, telaPesquisa.class);
                                //startActivity(intent);
                                //finish();
                            } else {
                                // Usuário não encontrado, exibir uma mensagem de erro ou tomar outra ação apropriada
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        // Limpar os campos
                                        email.setText("");
                                        senha.setText("");

                                        AlertDialog.Builder builder = new AlertDialog.Builder(telaLogin.this);
                                        builder.setMessage("Usuário ou senha inválidos");
                                        builder.create().show();
                                    }
                                });
                            }
                        }else {
                            //  exibir uma mensagem de erro ou tomar outra ação apropriada
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(telaLogin.this);
                                    builder.setMessage("Usuário ou senha inválidos");
                                    builder.create().show();
                                }
                            });
                        }
                    }
                }).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
