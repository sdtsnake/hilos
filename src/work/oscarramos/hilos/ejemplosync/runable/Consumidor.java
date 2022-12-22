package work.oscarramos.hilos.ejemplosync.runable;

import work.oscarramos.hilos.ejemplosync.Panaderia;

public class Consumidor implements Runnable{
    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

    }
}
