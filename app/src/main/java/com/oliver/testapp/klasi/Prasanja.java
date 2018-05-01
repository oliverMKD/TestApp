package com.oliver.testapp.klasi;

import java.io.Serializable;

public class Prasanja implements Serializable {
    String naziv;

    public Prasanja() {

    }

    public Prasanja(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
