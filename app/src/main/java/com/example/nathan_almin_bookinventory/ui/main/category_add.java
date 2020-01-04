package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;
import com.example.nathan_almin_bookinventory.database.repository.CategoryRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class category_add extends AppCompatActivity {

    FloatingActionButton add;
    EditText name;

    CategoryEntity categoryEntity;

    Toast toast;
    Toast errorToast;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_add);

        //instance components
        add = findViewById(R.id.validateButtonCat);
        name = findViewById(R.id.et_add_category_name);

        errorToast = Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT);
        toast= Toast.makeText(this, "Category added", Toast.LENGTH_SHORT);

        categoryEntity = new CategoryEntity();

        alertDialog = new AlertDialog.Builder(this).create();

        CategoryRepository categoryRepository = new CategoryRepository(getApplication());

        //Config button Add
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Check if all field are completed
                if(name.getText().toString().isEmpty()) {
                    errorToast.show();
                    return;
                }

                categoryEntity.setCatName(name.getText().toString());;

                categoryRepository.insert(categoryEntity);



                //info toast
                toast.show();

                alertDialog.setTitle("Category");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Category added");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (dialog, which) -> showCategory());
                alertDialog.show();

            }
        });

    }

    public void showCategory() {
        Intent intent = new Intent(this, category_add.class);
        startActivity(intent);
    }
}
