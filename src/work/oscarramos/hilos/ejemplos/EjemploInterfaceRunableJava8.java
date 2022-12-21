package work.oscarramos.hilos.ejemplos;

public class EjemploInterfaceRunableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
        Runnable viaje = () -> {

            for (int i = 0; i < 10; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random()) * 10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Me voy de viaje a :" + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread v1 =  new Thread(viaje, "Ney York");
        Thread v2 = new Thread(viaje, "Orlando");
        Thread v3 = new Thread(viaje, "Hawai");
        Thread v4 = new Thread(viaje, "San Francisco");

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        v1.join();
        v2.join();
        v3.join();
        v4.join();

        //Thread.sleep(1000);
        System.out.println("Continuando con la ejecucion del metodo main: " + main.getName());


    }
}
