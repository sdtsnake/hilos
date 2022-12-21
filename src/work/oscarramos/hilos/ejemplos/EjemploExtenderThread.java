package work.oscarramos.hilos.ejemplos;

import work.oscarramos.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Naked Snake");
        hilo.start();
        //Thread.sleep(1);
        Thread hilo2 = new NombreThread("Solid Snake");
        hilo2.start();


        NombreThread hilo3 = new NombreThread("Solidus snake");
        hilo3.start();

        System.out.println(hilo.getState());

    }
}
