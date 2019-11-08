package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.dao.BookDao;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;

import java.util.List;

public class BookRepository {
    private BookDao mBookDao;
    private LiveData<List<BookEntity>> mAllBooks;

    public BookRepository(Application application) {
        LocalDatabase db = LocalDatabase.getLocalDatabase(application);
        mBookDao = db.bookDao();
        mAllBooks = mBookDao.getAll();
    }

    public LiveData<List<BookEntity>> getAll() {
        return mAllBooks;
    }

    public void insertBook (BookEntity book) {
        new insertAsyncTask(mBookDao).execute(book);
    }

    private static class insertAsyncTask extends AsyncTask<BookEntity, Void, Void> {

        private BookDao mAsyncTaskDao;

        insertAsyncTask(BookDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final BookEntity... params) {
            mAsyncTaskDao.insertBook(params[0]);
            return null;
        }
    }

}