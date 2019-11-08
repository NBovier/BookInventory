package com.example.nathan_almin_bookinventory.database.dao;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;
import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface ShelfLocDao {

    @Query("SELECT * FROM shelfloc")
    LiveData<List<ShelfLocEntity>> getAll();

    @Query("SELECT * FROM shelfloc WHERE id IN (:shelflocIds)")
    LiveData<List<ShelfLocEntity>> loadAllByIds(int[] shelflocIds);


    @Insert
    void insertShelfLoc(ShelfLocEntity shelfLoc);

    @Update
    void updateShelfLoc(ShelfLocEntity... shelfLoc);

    @Delete
    void deleteShelfLoc(ShelfLocEntity shelfLoc);
}
