package com.example.nathan_almin_bookinventory.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.firebase.firestore.Exclude;

import java.util.HashMap;
import java.util.Map;


public class ShelfLocEntity {

    /*
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
     */

    private int id;
    private int etage;
    private int rang;
    private int bloc;
    private int numEtagere;

    public ShelfLocEntity() {

    }

    public ShelfLocEntity(int id, int etage, int rang, int bloc, int numEtagere) {
        this.id = id;
        this.etage = etage;
        this.rang = rang;
        this.bloc = bloc;
        this.numEtagere = numEtagere;
    }

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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("etage", etage);
        result.put("rang", rang);
        result.put("bloc", bloc);
        result.put("numEtagere", numEtagere);
        return result;
    }
}
