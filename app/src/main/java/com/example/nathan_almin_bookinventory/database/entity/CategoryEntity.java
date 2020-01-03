package com.example.nathan_almin_bookinventory.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.nathan_almin_bookinventory.database.async.CategoryCreate;
import com.google.firebase.firestore.Exclude;

import java.util.HashMap;
import java.util.Map;

public class CategoryEntity {


    /*
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        @ColumnInfo(name = "catName")
        private String catName;

    /*
        public CategoryEntity(int id, String catName) {
            this.id = id;
            this.catName = catName;
        }

     */
    private String catName;
    private int id;

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
