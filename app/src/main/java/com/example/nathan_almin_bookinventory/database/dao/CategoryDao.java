package com.example.nathan_almin_bookinventory.database.dao;

import java.util.List;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.OnConflictStrategy;

import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;

public interface CategoryDao {

    @Query("SELECT * FROM Categories")
    List<CategoryEntity> getAllS();

    @Query("SELECT * FROM Categories WHERE id = :id")
    CategoryEntity getById(int id);

    @Query("SELECT * FROM Categories WHERE catName = :catName")
    CategoryEntity getByName(String catName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CategoryEntity category);

    @Update
    void update(CategoryEntity category);

    @Delete
    void delete(CategoryEntity category);
}
