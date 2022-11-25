package com.psp.gbl;

public class Mayor implements Runnable{
    int[] numeros=new int[5];
    public Mayor(int[] numeros){
        this.numeros=numeros;

    }


    @Override
    public void run() {
        int mayor=0;
        for(int numero : numeros){
            if(numero>mayor){
                mayor=numero;
            }
        }
        System.out.println("el numero mayor es: "+ mayor);
    }
}
