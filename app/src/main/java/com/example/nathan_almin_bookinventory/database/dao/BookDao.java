package com.example.nathan_almin_bookinventory.database.dao;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nathan_almin_bookinventory.database.entity.BookEntity;

import java.util.List;
import androidx.lifecycle.LiveData;

public interface BookDao {

    @Query("SELECT * FROM books")
    LiveData<List<BookEntity>> getAll();

    @Query("SELECT * FROM books WHERE idAutor = :idAutor")
    LiveData<List<BookEntity>> loadAllByAutor(int idAutor);

    @Query("SELECT * FROM Books WHERE idCategory = :idCategory")
    LiveData<List<BookEntity>> getBooksByCategory(int idCategory);

    @Query("SELECT * FROM books WHERE title LIKE :title LIMIT 1")
    BookEntity findByName(String title);

    @Insert
    void insertBook(BookEntity book);

    @Update
    void updateBook(BookEntity book);

    @Delete
    void deleteBook(BookEntity books);

    @Query("DELETE FROM books")
    void deleteAll();
}
