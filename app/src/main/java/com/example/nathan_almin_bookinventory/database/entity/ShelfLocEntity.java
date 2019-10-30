package com.example.nathan_almin_bookinventory.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ShelfLocEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "etage")
    private int etage;

    @ColumnInfo(name = "rang")
    private int rang;

    @ColumnInfo(name = "bloc")
    private int bloc;

    @ColumnInfo(name = "numEtagere")
    private int numEtagere;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getBloc() {
        return bloc;
    }

    public void setBloc(int bloc) {
        this.bloc = bloc;
    }

    public int getNumEtagere() {
        return numEtagere;
    }

    public void setNumEtagere(int numEtagere) {
        this.numEtagere = numEtagere;
    }
}
