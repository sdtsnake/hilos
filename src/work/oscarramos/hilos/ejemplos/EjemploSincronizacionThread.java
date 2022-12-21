package work.oscarramos.hilos.ejemplos;

import work.oscarramos.hilos.ejemplos.runable.ImprimirFases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new ImprimirFases("Hola ","Que tal")).start();
        new Thread(new ImprimirFases("Quien eres ","tu?")).start();
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFases("Muchas ","gracias amigo!"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());
    };

    public synchronized static void imprimirFaces(String frase1, String frase2){
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(frase2);
    }
}
