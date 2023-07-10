package com.karol.tcc;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class,Academias.class},version = 4)
public abstract class AppDatabase  extends RoomDatabase {
    public abstract UsuarioDAO usuarioDao();
    public abstract AcademiasDAO academiasDAO();
}
