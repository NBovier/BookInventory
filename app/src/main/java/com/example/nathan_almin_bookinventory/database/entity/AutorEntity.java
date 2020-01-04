package com.example.nathan_almin_bookinventory.database.entity;


import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class AutorEntity {

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
