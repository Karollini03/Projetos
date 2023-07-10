package com.karol.tcc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AcademiasAdapter  extends RecyclerView.Adapter<AcademiasAdapter.viewholder>{

    List<Academias> academias;

     //List<Academias> academiasFiltradas;

    List<Academias> getUserModelListFilter;

    public AcademiasClickListener academiasClickListener;
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {


                FilterResults filterResults = new FilterResults();

                if(constraint == null || constraint.length() == 0){
                    filterResults.values = getUserModelListFilter;
                    filterResults.count = getUserModelListFilter.size();
                }else {
                    String searchStr = constraint.toString().toLowerCase();
                    List<Academias> academias = new ArrayList<>();
                    for (Academias academia: getUserModelListFilter){
                        if(academia.getAtividades().toLowerCase().contains(searchStr) || academia.getBairro().toLowerCase().contains(searchStr) ){  //aqui da pra adicionar mais filtros usando ||
                            academias.add(academia);
                        }
                    }

                    filterResults.values = academias;
                    filterResults.count = academias.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                academias = (List<Academias>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;

    }

    public interface AcademiasClickListener{
        void selectedUser(Academias academias);
    }

    public AcademiasAdapter(List<Academias> academias, AcademiasClickListener academiasClickListener) {
        this.academias = academias;
        this.getUserModelListFilter = academias;
        this.academiasClickListener = academiasClickListener;
        this.academias = new ArrayList<>(academias);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.academias_row,parent,false);
       return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        Academias academias1 = academias.get(position);

        holder.nome.setText(academias.get(position).getNome());
       // holder.email.setText("Email: "+academias.get(position).getEmail());
        //holder.telefone.setText("Telefone: "+academias.get(position).getTelefone());
        holder.atividades.setText("Atividades: "+academias.get(position).getAtividades());
        //holder.valor.setText("Valor mensal: "+ String.valueOf(academias.get(position).getValor()));
        //holder.aparelhos.setText("Aparelhos: "+academias.get(position).getAparelhos());
        holder.endereço.setText("Endereço: "+academias.get(position).getRua() + ", "+academias.get(position).getNumero()
                + ", "+academias.get(position).getBairro() + ", "+academias.get(position).getCidade());
        //holder.instagram.setText("Instagram: "+academias.get(position).getInstagram());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                academiasClickListener.selectedUser(academias1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return academias.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        public TextView nome, email, telefone, atividades, valor, aparelhos,endereço, instagram;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            nome=itemView.findViewById(R.id.nome);
            //email=itemView.findViewById(R.id.email);
            //telefone=itemView.findViewById(R.id.telefone);
            atividades=itemView.findViewById(R.id.atividades);
            //valor=itemView.findViewById(R.id.valor);
            //aparelhos=itemView.findViewById(R.id.aparelhos);
            endereço=itemView.findViewById(R.id.endereço);
            //instagram=itemView.findViewById(R.id.instagram);

        }
    }
}
