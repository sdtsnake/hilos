package work.oscarramos.hilos.ejemplos;

import work.oscarramos.hilos.ejemplos.runable.ViajeTarea;

public class EjemploInterfaceRunable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Ney York")).start();
        new Thread(new ViajeTarea("Orlando")).start();
        new Thread(new ViajeTarea("Hawai")).start();
        new Thread(new ViajeTarea("San Francisco")).start();
    }
}
