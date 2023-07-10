package com.karol.tcc;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();


    @Query("SELECT * FROM usuario WHERE email LIKE :email AND " +
            "senha LIKE :senha")
    Usuario findByName(String email, String senha);


    @Insert
    void insertAll(Usuario... usuarios);

    @Delete
    void delete(Usuario usuario);
}
