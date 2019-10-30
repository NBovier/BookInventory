package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.nathan_almin_bookinventory.R;
import com.google.android.material.navigation.NavigationView;

import android.support.design.widget.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        slider = findViewById(R.id.silder);

        //instance of navication drawer
        toggle = new ActionBarDrawerToggle(this, drawerLayout, "Open", "Close");
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        slider.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();


                        if (id == R.id.nav_books) {
                            showBooks();
                        }
                        if (id == R.id.nav_autors) {
                            showAuthors();
                        }
                        if (id == R.id.nav_shelflocs) {
                            showShelfLocs();
                        }

                        return onOptionsItemSelected(item);
                    }
                });
    }

    public void showBooks() {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }

    public void showAuthors() {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }

    public void showShelfLocs() {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }

    public void showBooks(View view) {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }
    public void showAuthors(View view) {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }

    public void showShelfLocs(View view) {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }
}
