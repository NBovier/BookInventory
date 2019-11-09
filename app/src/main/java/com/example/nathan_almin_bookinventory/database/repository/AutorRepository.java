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

    public AutorRepository(Application application) {
        LocalDatabase db = LocalDatabase.getLocalDatabase(application);
        mAutorDao = db.autorDao();
        mAllAutors = mAutorDao.getAll();
    }

    public LiveData<List<AutorEntity>> getAll() {
        return mAllAutors;
    }

    public void insertAutor (AutorEntity autor) {
        new AutorCreate(mAutorDao).execute(autor);
    }

    public void updateAutor (AutorEntity autor) {
        new AutorUpdate(mAutorDao).execute(autor);
    }

    public void deleteAutor (AutorEntity autor) {
        new AutorDelete(mAutorDao).execute(autor);
    }

}
