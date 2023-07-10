package com.karol.tcc;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "academias")
public class Academias implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id_academia;

    @ColumnInfo(name = "nome")
    public String nome;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "telefone")
    public String telefone;

    @ColumnInfo(name = "atividades")
    public String atividades;

    @ColumnInfo(name = "valor")
    public Double valor;

    @ColumnInfo(name = "aparelhos")
    public String aparelhos;

    @ColumnInfo(name = "rua")
    public String rua;

    @ColumnInfo(name = "numero")
    public int numero;

    @ColumnInfo(name = "bairro")
    public String bairro;

    @ColumnInfo(name = "cidade")
    public String cidade;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] fotos;

    @ColumnInfo(name = "Instagram")
    public String instagram;

    public int getId_academia() {
        return id_academia;
    }

    public void setId_academia(int id_academia) {
        this.id_academia = id_academia;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(String aparelhos) {
        this.aparelhos = aparelhos;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public byte[] getFotos() {
        return fotos;
    }

    public void setFotos(byte[] fotos) {
        this.fotos = fotos;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
