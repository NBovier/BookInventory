package com.example.nathan_almin_bookinventory.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.repository.BookRepository;

import java.util.List;

public class bookViewModel  extends AndroidViewModel {

    private BookRepository mRepository;

    private LiveData<List<BookEntity>> mAllBooks;

    public bookViewModel (Application application) {
        super(application);
        mRepository = new BookRepository(application);
        mAllBooks = mRepository.getAll();
    }

    public LiveData<List<BookEntity>> getAll() { return mAllBooks; }

    public void insert(BookEntity book) { mRepository.insertBook(book); }

    public void deleteBook(BookEntity book) {
        mRepository.deleteBook(book);
    }

    public void updateBook(BookEntity book) {
        mRepository.updateBook(book);
    }
}
