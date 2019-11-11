package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.async.BookCreate;
import com.example.nathan_almin_bookinventory.database.async.BookDelete;
import com.example.nathan_almin_bookinventory.database.async.BookUpdate;
import com.example.nathan_almin_bookinventory.database.dao.BookDao;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;

import java.util.List;

public class BookRepository {
    //Components
    private BookDao mBookDao;
    private LiveData<List<BookEntity>> mAllBooks;

    /**
     * Constructor
     * @param application
     */
    public BookRepository(Application application) {
        LocalDatabase db = LocalDatabase.getLocalDatabase(application);
        mBookDao = db.bookDao();
        mAllBooks = mBookDao.getAll();
    }

    public LiveData<List<BookEntity>> getAll() {
        return mAllBooks;
    }

    public void insertBook (BookEntity book) {
        new BookCreate(mBookDao).execute(book);
    }

    public void updateBook (BookEntity book) {
        new BookUpdate(mBookDao).execute(book);
    }

    public void deleteBook (BookEntity book) {
        new BookDelete(mBookDao).execute(book);
    }
}