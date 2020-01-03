package com.example.nathan_almin_bookinventory.database.LiveData;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShelfLocListLiveData   extends LiveData<List<ShelfLocEntity>> {
    private static final String TAG = "ShelfLocListLiveData";
    private final DatabaseReference reference;
    private final ShelfLocListLiveData.MyValueEventListener listener = new ShelfLocListLiveData.MyValueEventListener();

    public ShelfLocListLiveData(DatabaseReference ref) {
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
            setValue(toShelfLocList(dataSnapshot));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.e(TAG, "Can't listen to query " + reference, databaseError.toException());
        }
    }

    private List<ShelfLocEntity> toShelfLocList(DataSnapshot snapshot) {
        List<ShelfLocEntity> shelfLoc = new ArrayList<>();
        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
            ShelfLocEntity entity = childSnapshot.getValue(ShelfLocEntity.class);
            entity.setId(Integer.parseInt(childSnapshot.getKey()));
            shelfLoc.add(entity);
        }
        return shelfLoc;
    }
}
