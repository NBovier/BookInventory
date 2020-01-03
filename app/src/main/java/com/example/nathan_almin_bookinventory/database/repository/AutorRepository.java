package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;

import java.util.List;

public class AutorRepository {
    //Components
    /*private AutorDao mAutorDao;
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
*/
    private LiveData<List<AutorEntity>> mAllAutors;
    public AutorRepository(Application application) {
        mAllAutors = getAllAutors();
    }

    public void insert(AutorEntity autor) {
        String id = FirebaseDatabase.getInstance().getReference("autors").push().getKey();
        FirebaseDatabase.getInstance()
                .getReference("autors")
                .child(id)
                .setValue(autor);
    }

    public void update(AutorEntity autor, String Id) {
        FirebaseDatabase.getInstance()
                .getReference("autors")
                .child(Id)
                .updateChildren(autor.toMap());
    }

    public void delete(AutorEntity autor) {
        FirebaseDatabase.getInstance()
                .getReference("autors")
                .child(autor.getId())
                .removeValue();
    }


    public LiveData<List<AutorEntity>> getAllAutors() {
        DatabaseReference reference = FirebaseDatabase.getInstance()
                .getReference("autors");
        return new BikeListLiveData(reference);
    }
}
