package com.example.nathan_almin_bookinventory.database.LiveData;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AutorListLiveData extends LiveData<List<AutorEntity>>  {
    private static final String TAG = "AutorLiveData";
    private final DatabaseReference reference;
    private final MyValueEventListener listener = new MyValueEventListener();

    public AutorListLiveData(DatabaseReference ref) {
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
            setValue(toAutorList(dataSnapshot));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.e(TAG, "Can't listen to query " + reference, databaseError.toException());
        }
    }

    private List<AutorEntity> toAutorList(DataSnapshot snapshot) {
        List<AutorEntity> autors = new ArrayList<>();
        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
            AutorEntity entity = childSnapshot.getValue(AutorEntity.class);
            entity.setId(childSnapshot.getKey());
            autors.add(entity);
        }
        return autors;
    }
}
