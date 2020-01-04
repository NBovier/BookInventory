package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LiveData.ShelfLocListLiveData;
import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.async.ShelfLocCreate;
import com.example.nathan_almin_bookinventory.database.dao.ShelfLocDao;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;
import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ShelfLocRepository {
    private LiveData<List<ShelfLocEntity>> mAllShelfLocs;
    public ShelfLocRepository(Application application) {
        mAllShelfLocs = getAllShelfLocs();
    }

    public void insert(ShelfLocEntity shelfLoc) {
        String id = FirebaseDatabase.getInstance().getReference("shelfLocs").push().getKey();
        FirebaseDatabase.getInstance()
                .getReference("shelfLocs")
                .child(id)
                .setValue(shelfLoc);
    }

    public void update(ShelfLocEntity shelfLoc, String Id) {
        FirebaseDatabase.getInstance()
                .getReference("shelfLocs")
                .child(Id)
                .updateChildren(shelfLoc.toMap());
    }

    public void delete(ShelfLocEntity shelfLoc) {
        FirebaseDatabase.getInstance()
                .getReference("shelfLocs")
                .child(String.valueOf(shelfLoc.getId()))
                .removeValue();
    }


    public LiveData<List<ShelfLocEntity>> getAllShelfLocs() {
        DatabaseReference reference = FirebaseDatabase.getInstance()
                .getReference("shelfLocs");
        return new ShelfLocListLiveData(reference);
    }
}