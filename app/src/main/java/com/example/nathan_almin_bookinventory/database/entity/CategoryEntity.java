package com.example.nathan_almin_bookinventory.database.entity;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

@Entity
public class CategoryEntity {

    private String catName;
    @PrimaryKey
    private int id;
    @Ignore
    public CategoryEntity() {

    }

    public CategoryEntity(int id, String catName) {
        this.id = id;
        this.catName = catName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("catName", catName);
        return result;
    }
}
