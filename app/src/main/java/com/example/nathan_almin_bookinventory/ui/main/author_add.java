package com.example.nathan_almin_bookinventory.ui.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.repository.AutorRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class author_add extends AppCompatActivity {

    FloatingActionButton add;
    EditText name;

    AutorEntity autorEntity;

    Toast toast;
    Toast errorToast;
    Toast existToast;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_add);

        //instance components
        add = findViewById(R.id.validateButtonAut);
        name = findViewById(R.id.et_add_author_name);

        errorToast = Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT);
        toast= Toast.makeText(this, "Author added", Toast.LENGTH_SHORT);
        existToast= Toast.makeText(this, "Already exist", Toast.LENGTH_SHORT);

        autorEntity = new AutorEntity();

        alertDialog = new AlertDialog.Builder(this).create();

        AutorRepository autorRepository = new AutorRepository(getApplication());

        //Config button Add
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Check if all field are filled
                if(name.getText().toString().isEmpty()) {
                    errorToast.show();
                    return;
                }
                autorEntity.setAutorName(name.getText().toString());;

                autorRepository.insertAutor(autorEntity);



                //info toast
                toast.show();

                alertDialog.setTitle("Author");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Author added");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (dialog, which) -> showAuthors());
                alertDialog.show();

            }
        });

    }


    public void showAuthors() {
        Intent intent = new Intent(this, authors_search.class);
        startActivity(intent);
    }

}
