package com.example.nathan_almin_bookinventory.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.repository.AutorRepository;

import java.util.List;

public class authorViewModel extends AndroidViewModel {

    private AutorRepository mRepository;

    private LiveData<List<AutorEntity>> mAllAuthors;

    /**
     * Constructor
     * @param application
     */
    public authorViewModel (Application application) {
        super(application);
        mRepository = new AutorRepository(application);
        mAllAuthors = mRepository.getAllAutors();
    }

    public LiveData<List<AutorEntity>> getAll() { return mAllAuthors; }

    public void insert(AutorEntity author) { mRepository.insert(author); }

    public void deleteAuthor(AutorEntity author) {
        mRepository.delete(author);
    }

    public void updateAuthor(AutorEntity author, int id) {
        String idd = String.valueOf(id);
        mRepository.update(author, idd);
    }
}
