package com.karol.tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class telaPesquisa extends AppCompatActivity implements AcademiasAdapter.AcademiasClickListener{

    RecyclerView recycler;
    Toolbar toolbar;

    AcademiasAdapter adapter;

    List<Academias> academias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisa);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pesquise atividades ou bairros");


        recycler = findViewById(R.id.recycle_view);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // Código para exibir o AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(telaPesquisa.this);
        builder.setMessage("Clique no perfil das academias listadas, ou pesquise por atividades ou bairros!");
        builder.create().show();


        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "TCC").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        AcademiasDAO dao=db.academiasDAO();

        Academias academias1=new Academias();

        academias1.id_academia=1;
        academias1.nome="CT Move On";
        academias1.email="CTMove@gmail.com";
        academias1.instagram="ctmoveon";
        academias1.telefone="051995952521";
        academias1.atividades="Musculação, Funcional, CrossFit";
        academias1.valor=85.00;
        academias1.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias1.rua="Av. Lupicínio Rodrigues";
        academias1.numero=1431;
        academias1.bairro="Santa Rita";
        academias1.cidade="Guaíba";

        Academias academias2=new Academias();


        academias2.id_academia=2;
        academias2.nome="Studio Training Academia";
        academias2.email="TrainingAcademia@gmail.com";
        academias2.instagram="studiotrainingacademia";
        academias2.telefone="051997603674";
        academias2.atividades="Musculação";
        academias2.valor=80.00;
        academias2.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos ";
        academias2.rua="Av. Lupicínio Rodrigues";
        academias2.numero=1096;
        academias2.bairro="Santa Rita";
        academias2.cidade="Guaíba";

        Academias academias3=new Academias();

        academias3.id_academia=3;
        academias3.nome="IDEIA FITNESS";
        academias3.email="IdeiaFitness@gmail.com";
        academias3.instagram="ideiafitnessacademia";
        academias3.telefone="051995503655";
        academias3.atividades="Musculação";
        academias3.valor=80.00;
        academias3.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos ";
        academias3.rua="Av. Lupicínio Rodrigues";
        academias3.numero=1452;
        academias3.bairro="Santa Rita";
        academias3.cidade="Guaíba";

        Academias academias4=new Academias();

        academias4.id_academia=4;
        academias4.nome="Academia Podium";
        academias4.email="Podium@gmail.com";
        academias4.instagram="academia_podium";
        academias4.telefone="051995482394";
        academias4.atividades="Musculação";
        academias4.valor=75.00;
        academias4.aparelhos="Leg press 45, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias4.rua="Estr. Dr. José Carlos Ferreira";
        academias4.numero= 0;
        academias4.bairro="Pedras Brancas";
        academias4.cidade="Guaíba";

        Academias academias5=new Academias();

        academias5.id_academia=5;
        academias5.nome="TOP1 academia";
        academias5.email="TOP@gmail.com";
        academias5.instagram="top1academia";
        academias5.telefone="05134800748";
        academias5.atividades="Musculação";
        academias5.valor=80.00;
        academias5.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias5.rua="Av. Adão Foques";
        academias5.numero=1401;
        academias5.bairro="Jardim Iolanda";
        academias5.cidade="Guaíba";

        Academias academias6=new Academias();

        academias6.id_academia=6;
        academias6.nome="Coliseu Fitness";
        academias6.email="Coliseu@gmail.com";
        academias6.instagram="coliseu_fitnessacademia";
        academias6.telefone="051982961114";
        academias6.atividades="Musculação, Muay Thai , CrossFit, Zumba";
        academias6.valor=85.00;
        academias6.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Tatame, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias6.rua="Av. Adão Foques";
        academias6.numero=764;
        academias6.bairro="Alegria";
        academias6.cidade="Guaíba";

        Academias academias7=new Academias();

        academias7.id_academia=7;
        academias7.nome="Academia Tribo do Corpo";
        academias7.email="Tribo@gmail.com";
        academias7.instagram="academiatribodocorpooficial";
        academias7.telefone="051992210022";
        academias7.atividades="Muay Thai, taekwondo";
        academias7.valor=80.00;
        academias7.aparelhos="Tatame";
        academias7.rua="R. Duque de Caxias";
        academias7.numero=328;
        academias7.bairro="Alvorada";
        academias7.cidade="Guaíba";

        Academias academias8=new Academias();

        academias8.id_academia=8;
        academias8.nome="Pétrons Academia";
        academias8.email="Petrons@gmail.com";
        academias8.telefone="051999162765";
        academias8.atividades="Musculação, Funcional, Muay Thai";
        academias8.valor=80.00;
        academias8.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias8.rua="Av. Castelo Branco";
        academias8.numero=3130;
        academias8.bairro="Colina";
        academias8.cidade="Guaíba";

        Academias academias9=new Academias();

        academias9.id_academia=9;
        academias9.nome="Império Fitness";
        academias9.email="Império@gmail.com";
        academias9.instagram="vempraimperiofitness";
        academias9.telefone="05134023725";
        academias9.atividades="Musculação, Funcional";
        academias9.valor=75.00;
        academias9.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias9.rua="R. Olávo Lessa";
        academias9.numero=815;
        academias9.bairro="Colina";
        academias9.cidade="Guaíba";

        Academias academias10=new Academias();

        academias10.id_academia=10;
        academias10.nome="Academia RT Fitness";
        academias10.email="CTMove@gmail.com";
        academias10.instagram="academiartfitness";
        academias10.telefone="05121607320";
        academias10.atividades="Funcional, Zumba";
        academias10.valor=80.00;
        academias10.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias10.rua="Av. Adão Foques";
        academias10.numero=2814;
        academias10.bairro="Florida";
        academias10.cidade="Guaíba";

        Academias academias11=new Academias();

        academias11.id_academia=11;
        academias11.nome="JD Fitness Treinamento Funcional";
        academias11.email="JDFitness@gmail.com";
        academias11.instagram="jdfitnesstf";
        academias11.telefone="05132854115";
        academias11.atividades="Musculação, Funcional";
        academias11.valor=80.00;
        academias11.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias11.rua="R. Santa Clara";
        academias11.numero=154;
        academias11.bairro="Jardim dos Lagos";
        academias11.cidade="Guaíba";

        Academias academias12=new Academias();

        academias12.id_academia=12;
        academias12.nome="Academia Korpaço Musculação";
        academias12.email="Korpaço@gmail.com";
        academias12.telefone="051998477461";
        academias12.atividades="Musculação";
        academias12.valor=80.00;
        academias12.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias12.rua="R. São Paulo";
        academias12.numero=541;
        academias12.bairro="Parque 35";
        academias12.cidade="Guaíba";

        Academias academias13=new Academias();

        academias13.id_academia=13;
        academias13.nome="Academia Oyama - Matriz";
        academias13.email="Oyama@gmail.com";
        academias13.instagram="academiaoyama";
        academias13.telefone="05134801646";
        academias13.atividades="Musculação, Karate";
        academias13.valor=80.00;
        academias13.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias13.rua="R. São Paulo";
        academias13.numero=520;
        academias13.bairro="Parque 35,";
        academias13.cidade="Guaíba";

        Academias academias14=new Academias();

        academias14.id_academia=14;
        academias14.nome="Corpo e Forma Academia";
        academias14.email="corpoeforma@gmail.com";
        academias14.instagram="acadcorpoeforma";
        academias14.telefone="05121607320";
        academias14.atividades="Musculação, Funcional";
        academias14.valor=115.00;
        academias14.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias14.rua="R. Gaspar Martins";
        academias14.numero=322;
        academias14.bairro="Centro";
        academias14.cidade="Guaíba";

        Academias academias15=new Academias();

        academias15.id_academia=15;
        academias15.nome="Academia Factory Fitness";
        academias15.email="Factory@gmail.com";
        academias15.instagram="factoryacademia";
        academias15.telefone="051998222971";
        academias15.atividades="Musculação, Funcional";
        academias15.valor=80.00;
        academias15.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias15.rua="2° piso, Av. João Pessoa";
        academias15.numero=1335;
        academias15.bairro="Centro";
        academias15.cidade="Guaíba";

        Academias academias16=new Academias();

        academias16.id_academia=16;
        academias16.nome="Moinhos Fitness";
        academias16.email="Moinhos@gmail.com";
        academias16.instagram="moinhosfitness.guaiba";
        academias16.telefone="051994581486";
        academias16.atividades="Musculação, Funcional, Zumba, Kangoo, Fitdance, Dance";
        academias16.valor=120.00;
        academias16.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias16.rua="R. São José";
        academias16.numero=102;
        academias16.bairro="Centro";
        academias16.cidade="Guaíba";

        Academias academias17=new Academias();

        academias17.id_academia=17;
        academias17.nome="RE9 Academia";
        academias17.email="RE9@gmail.com";
        academias17.instagram="re9academia";
        academias17.telefone="05130551055";
        academias17.atividades="Musculação, Ginástica";
        academias17.valor=80.00;
        academias17.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias17.rua="R. Gaspar Martins";
        academias17.numero=69;
        academias17.bairro="Centro";
        academias17.cidade="Guaíba";


        Academias academias18=new Academias();

        academias18.id_academia=18;
        academias18.nome="Engenhus Academia";
        academias18.email="Engenhus@gmail.com";
        academias18.instagram="engenhus_academia";
        academias18.telefone="05134913818";
        academias18.atividades="Musculação, Muay Thai";
        academias18.valor=80.00;
        academias18.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias18.rua="Rua La Hire Guerra";
        academias18.numero=252;
        academias18.bairro="Engenho";
        academias18.cidade="Guaíba";

        Academias academias19=new Academias();

        academias19.id_academia=19;
        academias19.nome="CT STUDIO FITNESS";
        academias19.email="CTStudio@gmail.com";
        academias19.instagram="studiofitnessct";
        academias19.telefone="05121607320";
        academias19.atividades="Musculação, Funcional";
        academias19.valor=80.00;
        academias19.aparelhos="Leg press 45, Leg press 90, Esteira, Bicicleta, Cadeira Extensora e Abdutora, Hackmachine, Puxada, Remada, Bancos";
        academias19.rua="Av. Adão Foques";
        academias19.numero=2814;
        academias19.bairro="Florida";
        academias19.cidade="Guaíba";

        Academias academias20=new Academias();

        academias20.id_academia=20;
        academias20.nome="SuperForce CrossFit ";
        academias20.email="SuperForce@gmail.com";
        academias20.instagram="superforce.guaiba";
        academias20.telefone="051997650150";
        academias20.atividades="CrossFit, Funcional";
        academias20.valor=70.00;
        academias20.aparelhos= "Tatame";
        academias20.rua="Avenida Marechal";
        academias20.numero=2333;
        academias20.bairro="Av. Castelo Branco";
        academias20.cidade="Guaíba";

        dao.insertAll(academias1,academias2,academias3, academias4, academias5, academias6, academias7, academias8,
                academias9, academias10, academias11, academias12, academias13, academias14, academias15, academias16,
                academias17, academias18, academias19, academias20);

        academias = dao.getAll();
        academias = new ArrayList<>(academias);

        //List<Academias> academiasList = dao.getAll();
        adapter = new AcademiasAdapter(academias,this::selectedUser);
        recycler.setAdapter(adapter);


    }

    @Override
    public void selectedUser(Academias academias) {
        //Toast.makeText(this, "Academia selecionada: "+academias.getNome(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,SelectedUser.class).putExtra("data",academias));

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.searchView){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

        public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.search,menu);
            MenuItem menuItem = menu.findItem(R.id.searchView);
            SearchView searchView = (SearchView)menuItem.getActionView();
            searchView.setMaxWidth(Integer.MAX_VALUE);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    String searchStr = newText.toLowerCase();
                    if (adapter != null) {
                        adapter.getFilter().filter(searchStr); // Atualizar o filtro do adapter com o novo texto em minúsculas
                    }
                    return true;
                }
            });

            return super.onCreateOptionsMenu(menu);
        }



}
