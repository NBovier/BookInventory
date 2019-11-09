package com.example.nathan_almin_bookinventory.ui.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;
import com.example.nathan_almin_bookinventory.database.repository.ShelfLocRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class shelfloc_add extends AppCompatActivity {

    //Components
    FloatingActionButton add;
    EditText floor;
    EditText row;
    EditText block;
    EditText shelfNumber;

    ShelfLocEntity shelfLocEntity;
    Toast toast;
    Toast errorToast;

    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelfloc_add);

        //instance components
        add = findViewById(R.id.validateButton);
        floor = findViewById(R.id.et_add_shelfloc_floor);
        row = findViewById(R.id.et_add_shelfloc_row);
        block = findViewById(R.id.et_add_shelfloc_block);
        shelfNumber = findViewById(R.id.et_add_shelfloc_shelnumber);

        errorToast = Toast.makeText(this, "All fill must be completed", Toast.LENGTH_SHORT);
        toast= Toast.makeText(this, "Shelflocation added", Toast.LENGTH_SHORT);

        shelfLocEntity = new ShelfLocEntity();

        alertDialog = new AlertDialog.Builder(this).create();

        ShelfLocRepository shelfLocRepository = new ShelfLocRepository(getApplication());

        //Config button Add
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Check if all field are filled
                if(floor.getText().toString().matches("")){
                    errorToast.show();
                    return;
                }

                if(row.getText().toString().matches("")){
                    errorToast.show();
                    return;
                }

                if(block.getText().toString().matches("")){
                    errorToast.show();
                    return;
                }

                if(shelfNumber.getText().toString().matches("")){
                    errorToast.show();
                    return;
                }

                shelfLocEntity.setEtage(Integer.parseInt(floor.getText().toString()));
                shelfLocEntity.setRang(Integer.parseInt(row.getText().toString()));
                shelfLocEntity.setBloc(Integer.parseInt(block.getText().toString()));
                shelfLocEntity.setNumEtagere(Integer.parseInt(shelfNumber.getText().toString()));

                shelfLocRepository.insertShelfLoc(shelfLocEntity);



                //info toast
                toast.show();

                alertDialog.setTitle("Shelflocation");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Shelflocation added");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (dialog, which) -> showShelfLocs());
                alertDialog.show();

            }
        });

    }

    public void showShelfLocs() {
        Intent intent = new Intent(this, shelfloc_add.class);
        startActivity(intent);
    }
}
