package com.example.nathan_almin_bookinventory.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.async.AutorDelete;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.repository.AutorRepository;

import java.util.List;

public class authorViewModel extends AndroidViewModel {

    private AutorRepository mRepository;

    private LiveData<List<AutorEntity>> mAllAuthors;

    public authorViewModel (Application application) {
        super(application);
        mRepository = new AutorRepository(application);
        mAllAuthors = mRepository.getAll();
    }

    public LiveData<List<AutorEntity>> getAll() { return mAllAuthors; }

    public void insert(AutorEntity author) { mRepository.insertAutor(author); }

    public void deleteAuthor(AutorEntity author) {
        mRepository.deleteAutor(author);
    }

    public void updateAuthor(AutorEntity author) {
        mRepository.updateAutor(author);
    }
}
