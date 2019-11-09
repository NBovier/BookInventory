package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.dao.ShelfLocDao;
import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;

import java.util.List;

public class ShelfLocRepository {
    private ShelfLocDao mShelfLocDao;
    private LiveData<List<ShelfLocEntity>> mAllShelfLoc;

    public ShelfLocRepository(Application application) {
        LocalDatabase db = LocalDatabase.getLocalDatabase(application);
        mShelfLocDao = db.shelfLocDao();
        mAllShelfLoc = mShelfLocDao.getAll();
    }

    LiveData<List<ShelfLocEntity>> getAll() {
        return mAllShelfLoc;
    }

    public void insertShelfLoc (ShelfLocEntity shelfLoc) {
        new insertAsyncTask(mShelfLocDao).execute(shelfLoc);
    }

    private static class insertAsyncTask extends AsyncTask<ShelfLocEntity, Void, Void> {

        private ShelfLocDao mAsyncTaskDao;

        insertAsyncTask(ShelfLocDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ShelfLocEntity... params) {
            mAsyncTaskDao.insertShelfLoc(params[0]);
            return null;
        }
    }

}