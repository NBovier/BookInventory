package com.example.nathan_almin_bookinventory.database.LiveData;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BookListLiveData extends LiveData<List<BookEntity>> {
    private static final String TAG = "BookLiveData";
    private final DatabaseReference reference;
    private final BookListLiveData.MyValueEventListener listener = new BookListLiveData.MyValueEventListener();

    public BookListLiveData(DatabaseReference ref) {
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
            setValue(toBookList(dataSnapshot));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.e(TAG, "Can't listen to query " + reference, databaseError.toException());
        }
    }

    private List<BookEntity> toBookList(DataSnapshot snapshot) {
        List<BookEntity> books = new ArrayList<>();
        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
            BookEntity entity = childSnapshot.getValue(BookEntity.class);
            entity.setId(childSnapshot.getKey());
            books.add(entity);
        }
        return books;
    }
}
