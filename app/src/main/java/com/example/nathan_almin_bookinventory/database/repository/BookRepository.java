package com.example.nathan_almin_bookinventory.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.LiveData.BookListLiveData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class BookRepository {
    private LiveData<List<BookEntity>> mAllBooks;
    public BookRepository(Application application) {
        mAllBooks = getAllBooks();
    }

    public void insert(BookEntity book) {
        String id = FirebaseDatabase.getInstance().getReference("book").push().getKey();
        FirebaseDatabase.getInstance()
                .getReference("books")
                .child(id)
                .setValue(book);
    }

    public void update(BookEntity book, String Id) {
        FirebaseDatabase.getInstance()
                .getReference("books")
                .child(Id)
                .updateChildren(book.toMap());
    }

    public void delete(BookEntity book) {
        FirebaseDatabase.getInstance()
                .getReference("books")
                .child(String.valueOf(book.getId()))
                .removeValue();
    }


    public LiveData<List<BookEntity>> getAllBooks() {
        DatabaseReference reference = FirebaseDatabase.getInstance()
                .getReference("books");
        return new BookListLiveData(reference);
    }
}