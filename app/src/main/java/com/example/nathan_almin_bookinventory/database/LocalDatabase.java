package com.example.nathan_almin_bookinventory.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nathan_almin_bookinventory.database.dao.AutorDao;
import com.example.nathan_almin_bookinventory.database.dao.BookDao;
import com.example.nathan_almin_bookinventory.database.dao.CategoryDao;
import com.example.nathan_almin_bookinventory.database.dao.ShelfLocDao;
import com.example.nathan_almin_bookinventory.database.entity.AutorEntity;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;
import com.example.nathan_almin_bookinventory.database.entity.CategoryEntity;
import com.example.nathan_almin_bookinventory.database.entity.ShelfLocEntity;

@Database(entities = {AutorEntity.class, BookEntity.class, CategoryEntity.class, ShelfLocEntity.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {

    private static LocalDatabase INSTANCE;

    /* For Singleton instantiation */
    private static final Object LOCK = new Object();

    public abstract AutorDao autorDao();
    public abstract CategoryDao categoryDao();
    public abstract ShelfLocDao shelfLocDao();
    public abstract BookDao bookDao();


    public synchronized static LocalDatabase getLocalDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LocalDatabase.class, "bookinventory-database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}