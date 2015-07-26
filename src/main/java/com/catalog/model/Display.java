package com.catalog.model;

/**
 * Created by Dmitry on 09.07.2015.
 */
public class Display {
    private int id;
    private Manufacturer manufacturer_code;
    private float diagonal_length;
    private String diagonal_units;

    public Display() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manufacturer getManufacturer_code() {
        return manufacturer_code;
    }

    public void setManufacturer_code(Manufacturer manufacturer_code) {
        this.manufacturer_code = manufacturer_code;
    }

    public float getDiagonal_length() {
        return diagonal_length;
    }

    public void setDiagonal_length(float diagonal_length) {
        this.diagonal_length = diagonal_length;
    }

    public String getDiagonal_units() {
        return diagonal_units;
    }

    public void setDiagonal_units(String diagonal_units) {
        this.diagonal_units = diagonal_units;
    }
}
