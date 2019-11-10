package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.adapter.BookListAdapter;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.repository.BookRepository;
import com.example.nathan_almin_bookinventory.model.bookViewModel;
import com.example.nathan_almin_bookinventory.util.AdapterListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class books_search extends AppCompatActivity {

    private bookViewModel mbookViewModel;

    private List<BookEntity> mBooks;

    private AdapterListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final BookListAdapter adapter = new BookListAdapter(this, listener, mBooks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mbookViewModel = ViewModelProviders.of(this).get(bookViewModel.class);

        mbookViewModel.getAll().observe(this, new Observer<List<BookEntity>>() {
            @Override
            public void onChanged(@Nullable final List<BookEntity> books) {
                mBooks = books;
                // Update the cached copy of the words in the adapter.
                adapter.setBooks(books);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(books_search.this, book_add.class);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

    }

    //Open view activity_book_add
    public void addBook(View view) {
        Intent intent = new Intent(this, book_add.class);
        startActivity(intent);
    }


}
