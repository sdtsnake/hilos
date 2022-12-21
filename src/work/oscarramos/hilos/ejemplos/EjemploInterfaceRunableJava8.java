package work.oscarramos.hilos.ejemplos;

import work.oscarramos.hilos.ejemplos.runable.ViajeTarea;

public class EjemploInterfaceRunableJava8 {
    public static void main(String[] args) {

        Runnable viaje = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)(Math.random()) * 10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Me voy de viaje a :"  + Thread.currentThread().getName());
            }
        };

        new Thread(viaje,"Ney York").start();
        new Thread(viaje,"Orlando").start();
        new Thread(viaje,"Hawai").start();
        new Thread(viaje,"San Francisco").start();
    }
}
