package work.oscarramos.hilos.ejemplos.threads;

public class NombreThread extends Thread {
    @Override
    public void run() {
        System.out.println("Se inicia el metodo run del hilo " + getName());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName());
        }

        System.out.println("finaliza el hilo");
    }

    public NombreThread(String name) {
        super(name);
    }
}
