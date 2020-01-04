package com.example.nathan_almin_bookinventory.database.entity;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
@Entity
public class AutorEntity {

    @PrimaryKey
    private int id;

    private String autorName;

    @Ignore
    public AutorEntity(){

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
