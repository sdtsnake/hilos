package work.oscarramos.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService excutor = Executors.newSingleThreadExecutor();

        Runnable tarea = () ->{
            System.out.println("Inicio de la tarea....");
            try {
                System.out.println("Nombre del Thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Se finalizo la tarea...");
        };
        Future<?> restualtado = excutor.submit(tarea);
        excutor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        //System.out.println(restualtado.isDone());
        while(!restualtado.isDone()){
            System.out.println("Ejecutando tarea ....");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtenemos el resultado de la tarea " + restualtado.get(5,TimeUnit.SECONDS));
        System.out.println(restualtado.isDone());


   }
}
