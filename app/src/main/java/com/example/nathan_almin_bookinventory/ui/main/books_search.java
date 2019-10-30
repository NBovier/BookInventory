package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.example.nathan_almin_bookinventory.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class books_search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(books_search.this, book_add.class);
                startActivity(intent);
            }
        });
    }


    //Open view activity_book_add
    public void addBook(View view) {
        Intent intent = new Intent(this, book_add.class);
        startActivity(intent);
    }
}
