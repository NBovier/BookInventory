package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.adapter.AuthorListAdapter;
import com.example.nathan_almin_bookinventory.adapter.RecyclerAdapter;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.model.authorViewModel;
import com.example.nathan_almin_bookinventory.util.AdapterListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class authors_search extends AppCompatActivity implements AdapterListener{

    private authorViewModel mauthorViewModel;

    private List<AutorEntity> mAuthors;
    //private RecyclerAdapter<AutorEntity> adapter2;


    private AdapterListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerviewAut);
        final AuthorListAdapter adapter = new AuthorListAdapter(this, listener, mAuthors);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mauthorViewModel = ViewModelProviders.of(this).get(authorViewModel.class);

        mauthorViewModel.getAll().observe(this, new Observer<List<AutorEntity>>() {
            @Override
            public void onChanged(@Nullable List<AutorEntity> authors) {
                mAuthors = authors;
                // Update the cached copy of the words in the adapter.
                adapter.setAuthors(mAuthors);
            }
        });

        /*
        accounts = new ArrayList<>();
        adapter2 = new RecyclerAdapter<>(new AdapterListener() {
            @Override
            public void onItemClick(View v, int position) {accounts.get(position).getAutorName();

                Intent intent = new Intent(authors_search.this, author_details.class);
                intent.putExtra("autorId", accounts.get(position).getId());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View v, int position) {
                accounts.get(position).getAutorName();

            }
        });

         */

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(authors_search.this, author_add.class);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

    }

    //Open view activity_author_add
    public void addAuthor(View view) {
        Intent intent = new Intent(this, author_add.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {
        mAuthors.get(position);
        Intent intent = new Intent(this, author_details.class);
        intent.putExtra("author", (Parcelable) mAuthors.get(position));
        startActivity(intent);
    }
}
