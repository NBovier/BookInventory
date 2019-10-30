package com.example.nathan_almin_bookinventory.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nathan_almin_bookinventory.R;

public class book_add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);
    }

    public void showBooks(View view) {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }
}
