package work.oscarramos.hilos.ejemplosync.runable;

import work.oscarramos.hilos.ejemplosync.Panaderia;

import javax.swing.plaf.TableHeaderUI;
import java.nio.file.PathMatcher;
import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            panaderia.fabricar("Pan No. : " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
