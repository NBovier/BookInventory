package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.repository.BookRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;
import androidx.lifecycle.LiveData;

public class books_search extends AppCompatActivity {

    BookRepository br = new BookRepository(getApplication());
    ListView listBooks;
    SearchView searchView;
    ArrayAdapter<BookEntity> adapter;

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

        listBooks = (ListView)findViewById(R.id.listBooks);
    }

    //Update the listView depending of where we come from (Books from a specific category or specific author)
    private void updateListBook(){
        // get the fkAuthor or fkCategory if we access from Author or Category
        int fkAuthor = getIntent().getIntExtra("idAutor", -1);
        int fkCategory = getIntent().getIntExtra("idCategory", -1);

        //No intExtra --> allbooks
        if(fkAuthor+fkCategory==-2) {
            searchView.setQueryHint("Search");
            adapter = new ArrayAdapter<BookEntity>(books_search.this, android.R.layout.simple_list_item_1, (List<BookEntity>) getBooks());
        }
        adapter.notifyDataSetChanged();
        listBooks.setAdapter(adapter);
    }

    //Open view activity_book_add
    public void addBook(View view) {
        Intent intent = new Intent(this, book_add.class);
        startActivity(intent);
    }

    //Get all Books
    public LiveData<List<BookEntity>> getBooks(){
        return br.getAll();
    }

}
