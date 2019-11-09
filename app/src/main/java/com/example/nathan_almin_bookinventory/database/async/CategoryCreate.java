package com.example.nathan_almin_bookinventory.database.async;

import android.os.AsyncTask;

import com.example.nathan_almin_bookinventory.database.dao.CategoryDao;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;

public class CategoryCreate extends AsyncTask<CategoryEntity, Void, Void> {

    private CategoryDao mAsyncTaskDao;

    public CategoryCreate(CategoryDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final CategoryEntity... params) {
        mAsyncTaskDao.insertCategory(params[0]);
        return null;
    }
}
