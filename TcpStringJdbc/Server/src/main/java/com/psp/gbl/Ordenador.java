package com.psp.gbl;

import java.io.Serializable;

public class Ordenador implements Serializable {
    private final long serialVersionUID=2L;
    private int id;
    private String marca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Ordenador(int id, String marca) {
        this.id = id;
        this.marca = marca;
    }
}
