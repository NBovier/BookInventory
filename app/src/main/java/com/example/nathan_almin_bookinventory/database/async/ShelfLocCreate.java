package com.example.nathan_almin_bookinventory.database.async;

import android.app.Application;
import android.os.AsyncTask;

import com.example.nathan_almin_bookinventory.database.dao.ShelfLocDao;
import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;

import java.util.List;

public class ShelfLocCreate extends AsyncTask<ShelfLocEntity, Void, Void> {

    private ShelfLocDao mAsyncTaskDao;

    public ShelfLocCreate(ShelfLocDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final ShelfLocEntity... params) {
        mAsyncTaskDao.insertShelfLoc(params[0]);
        return null;
    }
}