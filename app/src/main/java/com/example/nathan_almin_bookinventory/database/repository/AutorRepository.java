package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.os.AsyncTask;
import com.example.nathan_almin_bookinventory.database.async.*;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.async.AutorCreate;
import com.example.nathan_almin_bookinventory.database.dao.AutorDao;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;

import java.util.List;

public class AutorRepository {
    private AutorDao mAutorDao;
    private LiveData<List<AutorEntity>> mAllAutors;

    AutorRepository(Application application) {
        LocalDatabase db = LocalDatabase.getLocalDatabase(application);
        mAutorDao = db.autorDao();
        mAllAutors = mAutorDao.getAll();
    }

    LiveData<List<AutorEntity>> getAll() {
        return mAllAutors;
    }

    public void insertAutor (AutorEntity autor) {
        new AutorCreate(mAutorDao).execute(autor);
    }

}
