package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LiveData.CategoryListLiveData;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.List;

public class CategoryRepository {
    private LiveData<List<CategoryEntity>> mAllCategories;
    public CategoryRepository(Application application) {
        mAllCategories = getAllCategories();
    }

    public void insert(CategoryEntity category) {
        String id = FirebaseDatabase.getInstance().getReference("categories").push().getKey();
        FirebaseDatabase.getInstance()
                .getReference("categories")
                .child(id)
                //.child(String.valueOf(incrementCounter()))
                .setValue(category);
    }

    public void update(CategoryEntity category, String Id) {
        FirebaseDatabase.getInstance()
                .getReference("categories")
                .child(Id)
                .updateChildren(category.toMap());
    }

    public void delete(CategoryEntity category) {
        FirebaseDatabase.getInstance()
                .getReference("categories")
                .child(String.valueOf(category.getId()))
                .removeValue();
    }


    public LiveData<List<CategoryEntity>> getAllCategories() {
        DatabaseReference reference = FirebaseDatabase.getInstance()
                .getReference("categories");
        return new CategoryListLiveData(reference);
    }

    public MutableData incrementCounter() {
        MutableData currentData2 = null;
        FirebaseDatabase.getInstance().getReference().runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData currentData) {
                if (currentData.getValue() == null) {
                    currentData.setValue(1);
                } else {
                    currentData.setValue((Long) currentData.getValue() + 1);
                }
                currentData = currentData2;
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                if(databaseError !=null){
                    Log.getStackTraceString(new Throwable("error"));
                } else{
                    Log.getStackTraceString(new Throwable("ok"));
                }
            }
        });
        return currentData2;
    }

}
