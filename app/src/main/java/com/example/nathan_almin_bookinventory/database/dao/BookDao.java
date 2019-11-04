package com.example.nathan_almin_bookinventory.database.dao;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nathan_almin_bookinventory.database.entity.BookEntity;

import java.util.List;

public interface BookDao {

    @Query("SELECT * FROM books")
    List<BookEntity> getAll();

    @Query("SELECT * FROM books WHERE idAutor = :idAutor")
    List<BookEntity> loadAllByAutor(int idAutor);

    @Query("SELECT * FROM Books WHERE idCategory = :idCategory")
    List<BookEntity> getBooksByCategory(int idCategory);

    @Query("SELECT * FROM books WHERE title LIKE :title LIMIT 1")
    BookEntity findByName(String title);

    @Insert
    void insertAll(BookEntity... books) throws SQLiteConstraintException;

    @Update
    void updateBooks(BookEntity... books);

    @Delete
    void delete(BookEntity books);

    @Query("DELETE FROM books")
    void deleteAll();
}
