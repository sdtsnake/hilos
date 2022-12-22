package work.oscarramos.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService excutor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () ->{
            System.out.println("Inicio de la tarea....");
            try {
                System.out.println("Nombre del Thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Se finalizo la tarea...");
            return "Algun resultado importante de la tarea";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 2 ....");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> restualtado = excutor.submit(tarea);
        Future<String> restualtado2 = excutor.submit(tarea);
        Future<Integer> restualtado3 = excutor.submit(tarea2);
        excutor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        //System.out.println(restualtado.isDone());
        while(!(restualtado.isDone() && restualtado2.isDone() && restualtado3.isDone())){
            System.out.println(String.format("Resultado1: %s - resultado2: %s - Resultado3: %s",
                    restualtado.isDone()? "finalizo": "en proceso",
                    restualtado2.isDone()? "finalizo":"en proceso",
                    restualtado3.isDone()? "finalizo":"en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("Obtenemos el resultado de la tarea : " + restualtado.get());
        System.out.println(restualtado.isDone());


   }
}
