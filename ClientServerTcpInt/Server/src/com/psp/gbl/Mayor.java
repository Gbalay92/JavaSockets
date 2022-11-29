package com.psp.gbl;

import java.util.concurrent.Callable;

public class Mayor implements Callable<Integer> {
    int[] numeros=new int[5];
    public Mayor(int[] numeros){
        this.numeros=numeros;

    }

    @Override
    public Integer call() throws Exception {
        int mayor=0;
        for(int numero : numeros){
            if(numero>mayor){
                mayor=numero;
            }
        }
        System.out.println("el numero mayor es: "+ mayor);
        return mayor;
    }


}
