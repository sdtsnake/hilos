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


    }
}
