package work.oscarramos.hilos.ejemploexecutor;

import work.oscarramos.hilos.ejemplosync.Panaderia;
import work.oscarramos.hilos.ejemplosync.runable.Consumidor;
import work.oscarramos.hilos.ejemplosync.runable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductoConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor excutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + excutor.getPoolSize());
        System.out.println("Cantidad de tareas en la cola: " + excutor.getQueue().size());

        Panaderia p = new Panaderia();

        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = excutor.submit(productor);
        Future<?> futuro2 = excutor.submit(consumidor);

        System.out.println("Tamaño del pool: " + excutor.getPoolSize());
        System.out.println("Cantidad de tareas en la cola: " + excutor.getQueue().size());

        excutor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");



   }
}
