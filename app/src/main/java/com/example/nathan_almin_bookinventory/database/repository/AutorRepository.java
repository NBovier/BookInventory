package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import com.example.nathan_almin_bookinventory.database.LiveData.AutorListLiveData;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AutorRepository {

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
                .child(String.valueOf(autor.getId()))
                .removeValue();
    }


    public LiveData<List<AutorEntity>> getAllAutors() {
        DatabaseReference reference = FirebaseDatabase.getInstance()
                .getReference("autors");
        return new AutorListLiveData(reference);
    }
}
