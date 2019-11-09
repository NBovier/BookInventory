package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.adapter.AuthorListAdapter;
import com.example.nathan_almin_bookinventory.adapter.BookListAdapter;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.model.authorViewModel;
import com.example.nathan_almin_bookinventory.model.bookViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.List;

public class authors_search extends AppCompatActivity {

    private authorViewModel mauthorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerviewAut);
        final AuthorListAdapter adapter = new AuthorListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mauthorViewModel = ViewModelProviders.of(this).get(authorViewModel.class);

        mauthorViewModel.getAll().observe(this, new Observer<List<AutorEntity>>() {
            @Override
            public void onChanged(@Nullable final List<AutorEntity> authors) {
                // Update the cached copy of the words in the adapter.
                adapter.setAuthors(authors);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(authors_search.this, author_add.class);
                startActivity(intent);
            }
        });
    }

    //Open view activity_author_add
    public void addAuthor(View view) {
        Intent intent = new Intent(this, author_add.class);
        startActivity(intent);
    }

}
