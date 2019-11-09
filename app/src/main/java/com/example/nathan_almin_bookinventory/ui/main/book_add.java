package com.example.nathan_almin_bookinventory.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.dao.AutorDao;
import com.example.nathan_almin_bookinventory.database.dao.BookDao;
import com.example.nathan_almin_bookinventory.database.dao.CategoryDao;
import com.example.nathan_almin_bookinventory.database.dao.ShelfLocDao;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.repository.AutorRepository;
import com.example.nathan_almin_bookinventory.database.repository.BookRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class book_add extends AppCompatActivity {

    FloatingActionButton add;
    EditText title;
    EditText date;
    Spinner author;
    Spinner category;
    EditText summary;

    BookEntity bookEntity;

    Toast toast;
    Toast errorToast;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);

        //instance components
        add = findViewById(R.id.validateButtonBook);
        title = findViewById(R.id.et_add_book_title);
        date = findViewById(R.id.et_add_book_date);
        author = findViewById(R.id.sp_add_book_author);
        category = findViewById(R.id.sp_add_book_categorie);
        summary = findViewById(R.id.et_add_book_summary);

        errorToast = Toast.makeText(this, "All fill must be completed", Toast.LENGTH_SHORT);
        toast= Toast.makeText(this, "Book added", Toast.LENGTH_SHORT);

        bookEntity = new BookEntity();

        alertDialog = new AlertDialog.Builder(this).create();

        BookRepository bookRepository = new BookRepository(getApplication());


        String[] arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        author.setAdapter(adapter);
        category.setAdapter(adapter);


        //Config button Add
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Check if all field are filled
                if(title.getText().toString().isEmpty() ||
                        date.getText().toString().isEmpty() ||
                        author.getSelectedItem().toString().isEmpty() ||
                        category.getSelectedItem().toString().isEmpty() ||
                        summary.getText().toString().isEmpty() ) {
                    errorToast.show();
                    return;
                }

                bookEntity.setTitle(title.getText().toString());
                bookEntity.setDate(date.getText().toString());
                bookEntity.setIdAutor(Integer.parseInt(author.getSelectedItem().toString()));
                bookEntity.setIdCategory(Integer.parseInt(category.getSelectedItem().toString()));
                bookEntity.setSummary(summary.getText().toString());

                bookRepository.insertBook(bookEntity);



                //info toast
                toast.show();

                alertDialog.setTitle("Book");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Book added");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (dialog, which) -> showBooks());
                alertDialog.show();

            }
        });

    }

    //return the index of a value in the spinner
    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }
        return 0;
    }

    public void showBooks() {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }

}
