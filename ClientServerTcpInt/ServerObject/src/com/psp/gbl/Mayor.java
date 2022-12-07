package com.psp.gbl;

import java.util.concurrent.Callable;

public class Mayor implements Callable<Contenedor> {
    int[] numeros=new int[5];
    public Mayor(int[] numeros){
        this.numeros=numeros;

    }




    @Override
    public Contenedor call() throws Exception {
        int mayor=0;
        for(int numero : numeros){
            if(numero>mayor){
                mayor=numero;
            }
        }
        System.out.println("el numero mayor es: "+ mayor);
        int numbers[] = new int[1];
        numbers[0]=mayor;
        return new Contenedor(numbers);
    }
}
