package work.oscarramos.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executur = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea del main");

        AtomicInteger contador = new AtomicInteger(5);
        //CountDownLatch lock = new CountDownLatch(5);

        Future<?> future = executur.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola mundo tarea ..... ");
        },1000,2000, TimeUnit.MILLISECONDS);

        //lock.await();
        //future.cancel(true);
        //TimeUnit.SECONDS.sleep(10);

        while (contador.get() >= 0 ){
            if(contador.get()==0){
                future.cancel(true);
                break;
            }
        }

        System.out.println("Alguna otra tarea del main....");
        executur.shutdown();


    }
}
