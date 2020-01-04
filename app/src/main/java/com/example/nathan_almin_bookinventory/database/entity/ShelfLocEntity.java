package com.example.nathan_almin_bookinventory.database.entity;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

@Entity
public class ShelfLocEntity {

    @PrimaryKey
    private int id;
    private int etage;
    private int rang;
    private int bloc;
    private int numEtagere;

    @Ignore
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
