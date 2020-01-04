package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.LiveData.CategoryListLiveData;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

}
