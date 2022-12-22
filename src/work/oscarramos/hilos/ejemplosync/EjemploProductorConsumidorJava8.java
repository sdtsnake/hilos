package work.oscarramos.hilos.ejemplosync;

import work.oscarramos.hilos.ejemplosync.runable.Consumidor;
import work.oscarramos.hilos.ejemplosync.runable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                p.fabricar("Pan No. : " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }).start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                p.consumir();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
