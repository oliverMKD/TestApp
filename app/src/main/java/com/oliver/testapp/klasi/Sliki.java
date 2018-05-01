package com.oliver.testapp.klasi;

import com.oliver.testapp.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Sliki implements Serializable {
    public int Slika;


    public Sliki(int slika) {
        Slika = slika;
    }

    public int getSlika() {
        return Slika;
    }

    public void setSlika(int slika) {
        Slika = slika;
    }
}
