package com.example.nathan_almin_bookinventory.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "autors")
public class AutorEntity {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "autor_name")
    private String autorName;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAutorName() { return autorName; }

    public void setAutorName(String autorName) { this.autorName = autorName; }

    public AutorEntity(int id, String autorName) {
        this.autorName = autorName;
        this.id = id;
    }
}
