package com.example.nathan_almin_bookinventory.ui.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.model.authorViewModel;
import com.example.nathan_almin_bookinventory.model.bookViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class book_details extends AppCompatActivity {

    //Components
    TextView title, date, author, category, loc, summary;

    String stitle, sdate, sauthor, scategory, sloc, sSummary;

    FloatingActionButton edit, delete, save;

    Toast errorToast, deleteToast, doneToast;

    BookEntity bookEntity;

    private bookViewModel mbookViewModel;

    private List<BookEntity> mBooks;

    @SuppressWarnings("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        title = findViewById(R.id.et_add_book_title);
        date = findViewById(R.id.et_add_book_date);
        author = findViewById(R.id.et_add_book_author);
        category = findViewById(R.id.et_add_book_categorie);
        loc = findViewById(R.id.et_add_book_loc);
        summary = findViewById(R.id.et_add_book_summary);

        edit = findViewById(R.id.editButton);
        delete = findViewById(R.id.deleteButton);
        save = findViewById(R.id.saveButton2);

        save.setVisibility(View.INVISIBLE);

        title.setEnabled(false);
        date.setEnabled(false);
        author.setEnabled(false);
        category.setEnabled(false);
        loc.setEnabled(false);
        summary.setEnabled(false);

        bookEntity = new BookEntity();

        // instance of toast
        doneToast = Toast.makeText(this, "Book saved", Toast.LENGTH_SHORT);
        errorToast = Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT);
        deleteToast = Toast.makeText(this, "Book deleted", Toast.LENGTH_SHORT);

        stitle = getIntent().getStringExtra("title");
        sdate = getIntent().getStringExtra("date");
        sauthor = getIntent().getStringExtra("author");
        scategory = getIntent().getStringExtra("category");
        sloc = getIntent().getStringExtra("loc");
        sSummary = getIntent().getStringExtra("summary");
        int position = getIntent().getIntExtra("pos", +0);

        title.setText(stitle);
        date.setText(sdate);
        author.setText(sauthor);
        category.setText(scategory);
        loc.setText(sloc);
        summary.setText(sSummary);

        mbookViewModel = ViewModelProviders.of(this).get(bookViewModel.class);

        mbookViewModel.getAll().observe(this, new Observer<List<BookEntity>>() {
            @Override
            public void onChanged(@Nullable List<BookEntity> books) {
                mBooks = books;
            }
        });

//set the listener to switch in edit mode
        edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                title.setEnabled(true);
                date.setEnabled(true);
                category.setEnabled(true);
                loc.setEnabled(true);
                author.setEnabled(true);
                summary.setEnabled(true);
                delete.setVisibility(View.INVISIBLE);
                save.setVisibility(View.VISIBLE);

            }
        });

        //delete the author from the database
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookEntity = mBooks.get(position);
                mbookViewModel.deleteBook(bookEntity);
                deleteToast.show();
                onBackPressed();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookEntity = mBooks.get(position);
                if(title.getText().toString().isEmpty()
                || date.getText().toString().isEmpty()
                || author.getText().toString().isEmpty()
                || category.getText().toString().isEmpty()
                || loc.getText().toString().isEmpty()
                || summary.getText().toString().isEmpty()){
                    errorToast.show();
                }else {
                    bookEntity.setTitle(title.getText().toString());
                    bookEntity.setIdLoc(Integer.parseInt(loc.getText().toString()));
                    bookEntity.setSummary(summary.getText().toString());
                    bookEntity.setIdCategory(Integer.parseInt(category.getText().toString()));
                    bookEntity.setIdAutor(Integer.parseInt(author.getText().toString()));
                    bookEntity.setDate(date.getText().toString());
                    mbookViewModel.updateBook(bookEntity);
                    doneToast.show();
                    onBackPressed();
                }
            }
        });

    }


}
