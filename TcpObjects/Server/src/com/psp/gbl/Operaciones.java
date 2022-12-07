package com.psp.gbl;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Operaciones implements Callable<Resultado> {
    private ArrayList<Contenedor> cont;

    public ArrayList<Contenedor> getCont() {
        return cont;
    }

    public void setCont(ArrayList<Contenedor> cont) {
        this.cont = cont;
    }

    public Operaciones(ArrayList<Contenedor> cont) {
        this.cont = cont;
    }

    @Override
    public Resultado call() throws Exception {
        int suma1=0;
        int suma2=0;
        for(Contenedor c : cont){
            if(c.isComprobador()){
                suma1+=c.getFactor();
            }else{
                suma2+=c.getFactor();
            }

        }
        return new Resultado(suma1, suma2);
    }
}
