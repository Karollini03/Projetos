package com.karol.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedUser extends AppCompatActivity {

    TextView Textnome, Textemail, Textinstagram, Texttelefone, Textatividades, Textvalor, Textaparelhos, Textendereço;

    Intent intent;

    Academias academias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);


        Textnome = findViewById(R.id.nome);
        Textemail = findViewById(R.id.email_telaSelected);
        Textinstagram = findViewById(R.id.instagram);
        Texttelefone = findViewById(R.id.telefone);
        Textatividades = findViewById(R.id.atividades);
        Textvalor = findViewById(R.id.valor);
        Textaparelhos = findViewById(R.id.aparelhos);
        Textendereço = findViewById(R.id.endereço);

        intent = getIntent();

        if(intent != null){
            academias = (Academias) intent.getSerializableExtra("data");

            String nome =academias.getNome();
            String email =academias.getEmail();
            String telefone =academias.getTelefone();
            String instagram =academias.getInstagram();
            String atividades =academias.getAtividades();
            String aparelhos =academias.getAparelhos();
            Double valor =academias.getValor();
            String endereço =academias.getRua()+", "+academias.getNumero()+", "+academias.getBairro()+", "+academias.getCidade();

            Textnome.setText(nome);
            Texttelefone.setText(" "+telefone);
            Textatividades.setText("Atividade(s): "+atividades);
            Textendereço.setText(" "+endereço);
            Textemail.setText(" "+email);
            Textinstagram.setText(" "+instagram);
            Textaparelhos.setText("Aparelhos: "+aparelhos);
            String valor1 =String.valueOf(valor);
            Textvalor.setText("R$ "+valor1);


        }


    }
}