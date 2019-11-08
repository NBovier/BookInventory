package com.example.nathan_almin_bookinventory.database.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.OnConflictStrategy;

import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;
import androidx.lifecycle.LiveData;

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM Categories")
    LiveData<List<CategoryEntity>> getAll();

    @Query("SELECT * FROM Categories WHERE id = :id")
    CategoryEntity getById(int id);

    @Query("SELECT * FROM Categories WHERE catName = :catName")
    CategoryEntity getByName(String catName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(CategoryEntity category);

    @Update
    void updateCategory(CategoryEntity category);

    @Delete
    void deleteCategory(CategoryEntity category);
}
