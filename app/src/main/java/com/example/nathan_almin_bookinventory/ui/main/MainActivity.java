package com.example.nathan_almin_bookinventory.ui.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.nathan_almin_bookinventory.R;
import com.example.nathan_almin_bookinventory.database.LocalDatabase;
import com.google.android.material.navigation.NavigationView;

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
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
                        if (id == R.id.nav_authors) {
                            showAuthors();
                        }
                        if (id == R.id.nav_shelflocs) {
                            showShelfLocs();
                        }
                        if (id == R.id.nav_category) {
                            showCategory();
                        }

                        return onOptionsItemSelected(item);
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (toggle != null)
            toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (toggle != null)
            toggle.onConfigurationChanged(newConfig);
    }

    public void showBooks() {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }

    public void showAuthors() {
        Intent intent = new Intent(this, authors_search.class);
        startActivity(intent);
    }

    public void showShelfLocs() {
        Intent intent = new Intent(this, shelfloc_add.class);
        startActivity(intent);
    }

    public void showCategory() {
        Intent intent = new Intent(this, category_add.class);
        startActivity(intent);
    }

    public void showBooks(View view) {
        Intent intent = new Intent(this, books_search.class);
        startActivity(intent);
    }
    public void showAuthors(View view) {
        Intent intent = new Intent(this, authors_search.class);
        startActivity(intent);
    }

    public void showShelfLocs(View view) {
        Intent intent = new Intent(this, shelfloc_add.class);
        startActivity(intent);
    }

    public void showCategory(View view) {
        Intent intent = new Intent(this, category_add.class);
        startActivity(intent);
    }
}
