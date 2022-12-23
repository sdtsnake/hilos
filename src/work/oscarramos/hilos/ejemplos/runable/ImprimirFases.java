package work.oscarramos.hilos.ejemplos.runable;

import static work.oscarramos.hilos.ejemplos.EjemploSincronizacionThread.imprimirFaces;

public class ImprimirFases implements Runnable{
    private String frase1, frase2;
    @Override
    public void run() {

        imprimirFaces(this.frase1, this.frase2);


    }

    public ImprimirFases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }
}
