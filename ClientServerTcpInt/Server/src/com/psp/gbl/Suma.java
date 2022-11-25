package com.psp.gbl;

public class Suma implements Runnable{
    int[] numeros=new int[5];
    public Suma(int[] numeros){
        this.numeros=numeros;

    }


    @Override
    public void run() {
        int resultado=0;
        for(int numero:numeros){
            resultado+=numero;
        }
        System.out.println("el resultado de la suma de los numeros es: " + resultado);
    }
}
