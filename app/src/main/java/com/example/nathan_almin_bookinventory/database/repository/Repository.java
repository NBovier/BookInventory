package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.dao.AutorDao;
import com.example.nathan_almin_bookinventory.database.dao.BookDao;
import com.example.nathan_almin_bookinventory.database.dao.CategoryDao;
import com.example.nathan_almin_bookinventory.database.dao.ShelfLocDao;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;

import java.util.List;

public class Repository {

    //DAO
    private AutorDao mAutorDao;
    private CategoryDao mCategoryDao;
    private BookDao mBookDao;
    private ShelfLocDao mShelfLocDao;

    //LiveData
    private LiveData<List<AutorEntity>> mAllAutors;
    private LiveData<List<BookEntity>> mAllBooks;
    private LiveData<List<CategoryEntity>> mAllCategories;

    Repository(Application application) {
        LocalDatabase db = LocalDatabase.getLocalDatabase(application);


        mAutorDao = db.autorDao();
        mCategoryDao = db.categoryDao();
        mBookDao = db.bookDao();
        mShelfLocDao = db.shelfLocDao();

        mAllAutors = mAutorDao.getAll();
        mAllBooks = mBookDao.getAll();
        mAllCategories = mCategoryDao.getAll();
    }

    LiveData<List<AutorEntity>> getAllAutors() {
        return mAllAutors;
    }
    LiveData<List<BookEntity>> getAllBooks() {
        return mAllBooks;
    }
    LiveData<List<CategoryEntity>> getAllCategories() {
        return mAllCategories;
    }

    public void insert (AutorEntity autor) {
        new insertAsyncTask(mAutorDao).execute(autor);
    }

    private static class insertAsyncTask extends AsyncTask<AutorEntity, Void, Void> {

        private AutorDao mAsyncTaskDao;

        insertAsyncTask(AutorDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final AutorEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
