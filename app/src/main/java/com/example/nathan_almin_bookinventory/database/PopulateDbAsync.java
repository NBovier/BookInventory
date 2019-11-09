package com.example.nathan_almin_bookinventory.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.nathan_almin_bookinventory.database.dao.BookDao;
import com.example.nathan_almin_bookinventory.database.entity.BookEntity;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    public static void populateDatabase(final LocalDatabase db) {
        Log.i("init", "Inserting demo data.");
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private final LocalDatabase database;

    PopulateDbAsync(LocalDatabase db) {
        database = db;
    }

    @Override
    protected Void doInBackground(final Void... params) {
        //populateWithTestData(database);
        return null;
    }

    /*
    private static void populateWithTestData(final LocalDatabase db) {
        // Start the app with a clean database every time.
        // Not needed if you only populate the database
        // when it is first created
        db.bookDao().deleteAll();

        addBook(db,
                "test", "12.12.12", "test", 1, 1, 1
        );
    }
*/

    private static void addBook(final LocalDatabase db,
                                  final String title,
                                  final String date,
                                  final String summary,
                                  final int idAutor,
                                  final int idCategory,
                                  final int idLoc) {
        BookEntity book = new BookEntity(title, date, summary, idAutor, idCategory, idLoc);
        db.bookDao().insertBook(book);
    }
}

