package com.example.nathan_almin_bookinventory.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.firebase.firestore.Exclude;

import java.util.HashMap;
import java.util.Map;

public class AutorEntity {
    /*@NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "autor_name")
    private String autorName;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAutorName() { return autorName; }

    public void setAutorName(String autorName) { this.autorName = autorName; }
    */

    private int id;

    private String autorName;

    public AutorEntity() {

    }

    public AutorEntity(int id, String autorName) {
        this.id = id;
        this.autorName = autorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("autorName", autorName);
        return result;
    }

}
