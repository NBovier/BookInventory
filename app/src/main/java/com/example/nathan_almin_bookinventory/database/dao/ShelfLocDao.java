package com.example.nathan_almin_bookinventory.database.dao;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;

import java.util.List;

public interface ShelfLocDao {

    @Query("SELECT * FROM shelfloc")
    List<ShelfLocEntity> getAll();

    @Query("SELECT * FROM shelfloc WHERE id IN (:shelflocIds)")
    List<ShelfLocEntity> loadAllByIds(int[] shelflocIds);


    @Insert
    void insertAll(ShelfLocEntity... books) throws SQLiteConstraintException;

    @Update
    void updateFruits(ShelfLocEntity... books);

    @Delete
    void delete(ShelfLocEntity books);

    @Query("DELETE FROM books")
    void deleteAll();
}
