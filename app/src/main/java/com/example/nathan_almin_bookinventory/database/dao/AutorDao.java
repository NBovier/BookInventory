package com.example.nathan_almin_bookinventory.database.dao;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.*;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;

import java.util.List;

public interface AutorDao {

    @Query("SELECT * FROM autors")
    List<AutorEntity> getAll();

    @Query("SELECT * FROM autors WHERE id IN (:autorIds)")
    List<AutorEntity> loadAllByIds(int[] autorIds);

    @Query("SELECT * FROM autors WHERE autor_name LIKE :autorName LIMIT 1")
    AutorEntity findByName(String autorName);

    @Insert
    void insertAll(AutorEntity... autors) throws SQLiteConstraintException;

    @Update
    void updateFruits(AutorEntity... autors);

    @Delete
    void delete(AutorEntity fruits);

    @Query("DELETE FROM autors")
    void deleteAll();
}
