package work.oscarramos.hilos.ejemplosync;

import work.oscarramos.hilos.ejemplosync.runable.Consumidor;
import work.oscarramos.hilos.ejemplosync.runable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
