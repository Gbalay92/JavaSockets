package com.psp.gbl;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contenedor implements Serializable {
    private final long serialVersionUID=1L;
    private int factor;
    private boolean comprobador;

    public Contenedor(int factor, boolean comprobador) {
        this.factor = factor;
        this.comprobador = comprobador;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public boolean isComprobador() {
        return comprobador;
    }

    public void setComprobador(boolean comprobador) {
        this.comprobador = comprobador;
    }
}