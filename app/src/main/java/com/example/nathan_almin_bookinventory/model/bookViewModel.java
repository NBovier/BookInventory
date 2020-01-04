package com.example.nathan_almin_bookinventory.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.repository.BookRepository;

import java.util.List;

public class bookViewModel  extends AndroidViewModel {

    private BookRepository mRepository;

    private LiveData<List<BookEntity>> mAllBooks;

    /**
     * Constructor
     * @param application
     */
    public bookViewModel (Application application) {
        super(application);
        mRepository = new BookRepository(application);
        mAllBooks = mRepository.getAllBooks();
    }

    public LiveData<List<BookEntity>> getAll() { return mAllBooks; }

    public void insert(BookEntity book) { mRepository.insert(book); }

    public void delete(BookEntity book) {
        mRepository.delete(book);
    }

    public void update(BookEntity book, String id) {
        String idd = String.valueOf(id);
        mRepository.update(book, id);
    }
}
