package com.example.nathan_almin_bookinventory.database.async;

import android.os.AsyncTask;

import com.example.nathan_almin_bookinventory.database.dao.BookDao;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;

public class BookUpdate extends AsyncTask<BookEntity, Void, Void> {

    private BookDao mAsyncTaskDao;

    public BookUpdate(BookDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final BookEntity... params) {
        mAsyncTaskDao.updateBook(params[0]);
        return null;
    }
}