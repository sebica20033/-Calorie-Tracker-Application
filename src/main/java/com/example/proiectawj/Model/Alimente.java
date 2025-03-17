package com.example.proiectawj.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name="alimente")


public class Alimente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nume;
    private int calorii;
    private int proteine;
    private int carbohidrati;
    private int grasimi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCalorii() {
        return calorii;
    }

    public void setCalorii(int calorii) {
        this.calorii = calorii;
    }

    public int getProteine() {
        return proteine;
    }

    public void setProteine(int proteine) {
        this.proteine = proteine;
    }

    public int getCarbohidrati() {
        return carbohidrati;
    }

    public void setCarbohidrati(int carbohidrati) {
        this.carbohidrati = carbohidrati;
    }

    public int getGrasimi() {
        return grasimi;
    }

    public void setGrasimi(int grasimi) {
        this.grasimi = grasimi;
    }

}



