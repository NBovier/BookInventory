package com.example.nathan_almin_bookinventory.ui.main;

import androidx.appcompat.app.AppCompatActivity;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class author_details extends AppCompatActivity {

    //Components
    TextView autorName;

    FloatingActionButton edit;
    FloatingActionButton delete;

    Toast errorToast;
    Toast deleteToast;
    Toast doneToast;

    AutorRepository autorRepository;
    AutorDao autorDao;
    AutorEntity autorEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_details);

        autorName = findViewById(R.id.tv_details_author_Showfirstname);
        edit = findViewById(R.id.editButton);
        delete = findViewById(R.id.deleteButton);

        // instance of toast
        doneToast = Toast.makeText(this, "Author saved", Toast.LENGTH_SHORT);
        errorToast = Toast.makeText(this, "All filed must be complete", Toast.LENGTH_SHORT);
        deleteToast = Toast.makeText(this, "Author deleted", Toast.LENGTH_SHORT);

        //get idAuthor from previous activity
        int idAuthor = getIntent().getIntExtra("idAutor", -1);

        autorEntity = autorDao.loadById(autorEntity.getId());

        autorName.setText(autorEntity.getAutorName());
        autorName.setEnabled(false);

        //set the listener to switch in edit mode
        edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                delete.setVisibility(v.INVISIBLE);

                edit.setEnabled(false);

                autorName.setEnabled(true);
            }
        });

        //delete the author from the database
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autorRepository.deleteAutor(autorEntity);
                deleteToast.show();
                onBackPressed();
            }
        });

    }
}
