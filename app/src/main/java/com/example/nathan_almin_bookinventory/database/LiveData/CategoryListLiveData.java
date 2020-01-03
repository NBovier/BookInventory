package com.example.nathan_almin_bookinventory.database.LiveData;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryListLiveData  extends LiveData<List<CategoryEntity>> {
    private static final String TAG = "CategoryLiveData";
    private final DatabaseReference reference;
    private final CategoryListLiveData.MyValueEventListener listener = new CategoryListLiveData.MyValueEventListener();

    public CategoryListLiveData(DatabaseReference ref) {
        reference = ref;
    }

    @Override
    protected void onActive() {
        Log.d(TAG, "onActive");
        reference.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        Log.d(TAG, "onInactive");
    }

    private class MyValueEventListener implements ValueEventListener {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            setValue(toCategoryList(dataSnapshot));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.e(TAG, "Can't listen to query " + reference, databaseError.toException());
        }
    }

    private List<CategoryEntity> toCategoryList(DataSnapshot snapshot) {
        List<CategoryEntity> categories = new ArrayList<>();
        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
            CategoryEntity entity = childSnapshot.getValue(CategoryEntity.class);
            entity.setId(Integer.parseInt(childSnapshot.getKey()));
            categories.add(entity);
        }
        return categories;
    }
}
