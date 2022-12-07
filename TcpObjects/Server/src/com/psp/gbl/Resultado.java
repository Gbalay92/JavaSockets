package com.psp.gbl;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Resultado implements Serializable {
    private final long serialVersionUID=2L;
    private int suma1;
    private int suma2;

    public int getSuma2() {
        return suma2;
    }

    public void setSuma2(int suma2) {
        this.suma2 = suma2;
    }

    public int getSuma1() {
        return suma1;
    }

    public void setSuma1(int suma1) {
        this.suma1 = suma1;
    }

    public Resultado(int suma1, int suma2) {
        this.suma1 = suma1;
        this.suma2 = suma2;
    }
}
