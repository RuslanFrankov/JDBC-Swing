package com.catalog.model;

/**
 * Created by Dmitry on 15.06.2015.
 */
public class Currency {
    private String code;
    private String symbol;
    private String name;

    public Currency (){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
