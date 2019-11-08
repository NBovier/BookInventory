package com.example.nathan_almin_bookinventory.database.async;

import android.os.AsyncTask;

import com.example.nathan_almin_bookinventory.database.dao.AutorDao;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;

public class AutorUpdate extends AsyncTask<AutorEntity, Void, Void> {

    private AutorDao mAsyncTaskDao;

    public AutorUpdate(AutorDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final AutorEntity... params) {
        mAsyncTaskDao.updateAutor(params[0]);
        return null;
    }
}
