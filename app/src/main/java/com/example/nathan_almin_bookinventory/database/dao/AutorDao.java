package com.example.nathan_almin_bookinventory.database.dao;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.*;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;

import java.util.List;
import androidx.lifecycle.LiveData;

@Dao
public interface AutorDao {

    @Query("SELECT * FROM autors")
    LiveData<List<AutorEntity>> getAll();

    @Query("SELECT * FROM autors WHERE id IN (:autorIds)")
    LiveData<List<AutorEntity>> loadAllByIds(int[] autorIds);

    @Query("SELECT * FROM autors WHERE autor_name LIKE :autorName LIMIT 1")
    AutorEntity findByName(String autorName);

    @Insert
    void insertAutor(AutorEntity autor);

    @Update
    void updateAutor(AutorEntity... autors);

    @Delete
    void deleteAutor(AutorEntity autor);

    @Query("DELETE FROM autors")
    void deleteAll();
}
