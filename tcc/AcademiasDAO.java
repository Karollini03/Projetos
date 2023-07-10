package com.karol.tcc;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AcademiasDAO {

    @Query("SELECT * FROM academias")
     List<Academias> getAll();


    @Query("SELECT * FROM academias WHERE atividades IN (:atividades)")
    List<Academias> getByAtividades(List<String> atividades);

    @Query("SELECT * FROM academias WHERE id_academia = :id")
    Academias getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    default void insertAll(@NonNull Academias... academias) {
        for (Academias academia : academias) {
            long id = academia.getId_academia();
            if (getById(id) == null) {
                insert(academia);
            }
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Academias academia);

    @Delete
    void delete(Academias academia);
}
