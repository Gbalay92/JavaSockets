package com.psp.gbl;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Contenedor implements Serializable {
    private int[] numbers;

    public Contenedor(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
