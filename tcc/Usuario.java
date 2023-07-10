package com.karol.tcc;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    public int id_usuario;

    @ColumnInfo(name = "nome")
    public String nome;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "senha")
    public String senha;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
