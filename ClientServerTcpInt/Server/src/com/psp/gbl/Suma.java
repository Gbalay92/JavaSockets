package com.psp.gbl;

import java.util.concurrent.Callable;

public class Suma implements Callable<Integer> {
    int[] numeros=new int[5];
    public Suma(int[] numeros){
        this.numeros=numeros;

    }

    @Override
    public Integer call() throws Exception {
            int resultado=0;
            for(int numero:numeros){
                resultado+=numero;
            }
            System.out.println("el resultado de la suma de los numeros es: " + resultado);
            return resultado;
        }


}
