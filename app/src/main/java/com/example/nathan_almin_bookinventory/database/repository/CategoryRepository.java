package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.dao.CategoryDao;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;

import java.util.List;

public class CategoryRepository {
    private CategoryDao mCategoryDao;
    private LiveData<List<CategoryEntity>> mAllCategory;

    public CategoryRepository(Application application) {
        LocalDatabase db = LocalDatabase.getLocalDatabase(application);
        mCategoryDao = db.categoryDao();
        mAllCategory = mCategoryDao.getAll();
    }

    public LiveData<List<CategoryEntity>> getAll() {
        return mAllCategory;
    }

    public void insertCategory(CategoryEntity category) {
        new insertAsyncTask(mCategoryDao).execute(category);
    }

    private static class insertAsyncTask extends AsyncTask<CategoryEntity, Void, Void> {

        private CategoryDao mAsyncTaskDao;

        insertAsyncTask(CategoryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final CategoryEntity... params) {
            mAsyncTaskDao.insertCategory(params[0]);
            return null;
        }
    }
}
