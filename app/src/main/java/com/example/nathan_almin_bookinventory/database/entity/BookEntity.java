package com.example.nathan_almin_bookinventory.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import androidx.room.Index;

import java.util.Date;

@Entity(tableName = "books",
        foreignKeys ={
                @ForeignKey(
                        entity = CategoryEntity.class, parentColumns = "id", childColumns = "idCategory", onDelete = ForeignKey.CASCADE),
                @ForeignKey(
                        entity = AutorEntity.class, parentColumns = "id", childColumns = "idAutor", onDelete = ForeignKey.CASCADE)},
        indices = {
                @Index(
                        value = {"idAutor"}
                ),
                @Index(
                        value = {"idCategory"}
                )}
)
public class BookEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "summary")
    private String summary;

    @ColumnInfo(name = "idCategory")
    private int idCategory;

    @ColumnInfo(name = "idAutor")
    private int idAutor;

    @ColumnInfo(name = "idLoc")
    private int idLoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
