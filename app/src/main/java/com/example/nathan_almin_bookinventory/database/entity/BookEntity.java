package com.example.nathan_almin_bookinventory.database.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;
/*
@Entity(tableName = "books",
        foreignKeys ={
                @ForeignKey(
                        entity = CategoryEntity.class, parentColumns = "id", childColumns = "idCategory", onDelete = ForeignKey.CASCADE),
                @ForeignKey(
                        entity = AutorEntity.class, parentColumns = "id", childColumns = "idAutor", onDelete = ForeignKey.CASCADE),
                @ForeignKey(
                        entity = ShelfLocEntity.class, parentColumns = "id", childColumns = "idLoc", onDelete = ForeignKey.CASCADE)},
        indices = {
                @Index(
                        value = {"idAutor"}
                ),
                @Index(
                        value = {"idCategory"}
                ),
                @Index(
                        value = {"idLoc"}
                )}
)*/
@Entity
public class BookEntity {

    @PrimaryKey
    @NonNull
    private String id;
    private String title;
    private String date;
    private String summary;
    private int idCategory;
    private int idAutor;
    private int idLoc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    @Ignore
    public BookEntity(){

    }

    public BookEntity(String title, String date, String summary, int idAutor, int idCategory, int idLoc) {
        this.title = title;
        this.date = date;
        this.summary = summary;
        this.idAutor = idAutor;
        this.idCategory = idCategory;
        this.idLoc = idLoc;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("date", date);
        result.put("summary", summary);
        result.put("idAutor", idAutor);
        result.put("idCategory", idCategory);
        result.put("idLoc", idLoc);
        return result;
    }
}
