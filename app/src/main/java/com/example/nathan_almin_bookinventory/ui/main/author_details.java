package com.example.nathan_almin_bookinventory.ui.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.dao.AutorDao;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.repository.AutorRepository;
import com.example.nathan_almin_bookinventory.model.authorViewModel;
import com.example.nathan_almin_bookinventory.util.AdapterListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class author_details extends AppCompatActivity {

    //Components
    TextView authorName;
    String nameAuthor;

    FloatingActionButton edit;
    FloatingActionButton delete;
    FloatingActionButton save;

    Toast errorToast;
    Toast deleteToast;
    Toast doneToast;

    AutorRepository autorRepository;
    AutorDao autorDao;
    AutorEntity autorEntity;

    private authorViewModel mauthorViewModel;

    private List<AutorEntity> mAuthors;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_details);

        authorName = findViewById(R.id.tv_details_author_Showfirstname);
        edit = findViewById(R.id.editButton);
        delete = findViewById(R.id.deleteButton);
        save = findViewById(R.id.saveButton);

        save.setVisibility(View.INVISIBLE);

        authorName.setEnabled(false);

        autorEntity = new AutorEntity();

        // instance of toast
        doneToast = Toast.makeText(this, "Author saved", Toast.LENGTH_SHORT);
        errorToast = Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT);
        deleteToast = Toast.makeText(this, "Author deleted", Toast.LENGTH_SHORT);

        //get idAuthor from previous activity
        nameAuthor = getIntent().getStringExtra("authorName");
        int position = getIntent().getIntExtra("pos", +0);

        authorName.setText(nameAuthor);
        mauthorViewModel = ViewModelProviders.of(this).get(authorViewModel.class);

        mauthorViewModel.getAll().observe(this, new Observer<List<AutorEntity>>() {
            @Override
            public void onChanged(@Nullable List<AutorEntity> authors) {
                mAuthors = authors;
            }
        });

        //set the listener to switch in edit mode
        edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                authorName.setEnabled(true);
                delete.setVisibility(View.INVISIBLE);
                save.setVisibility(View.VISIBLE);

            }
        });

        //delete the author from the database
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autorEntity = mAuthors.get(position);
                mauthorViewModel.deleteAuthor(autorEntity);
                deleteToast.show();
                onBackPressed();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autorEntity = mAuthors.get(position);
                if(authorName.getText().toString().isEmpty()){
                    errorToast.show();
                }else {
                    autorEntity.setAutorName(authorName.getText().toString());
                    mauthorViewModel.updateAuthor(autorEntity);
                    doneToast.show();
                    onBackPressed();
                }
            }
        });

    }
}
