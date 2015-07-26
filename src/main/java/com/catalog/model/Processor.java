package com.catalog.model;

/**
 * Created by Dmitry on 15.06.2015.
 */
public class Processor {
    private Manufacturer manufacturer;
    private int id;
    private byte cores_number;

    public Processor() {
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getCores_number() {
        return cores_number;
    }

    public void setCores_number(byte cores_number) {
        this.cores_number = cores_number;
    }
}
