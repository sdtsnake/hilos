package work.oscarramos.hilos.ejemplosync;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void fabricar(String masa){
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.pan =  masa;
        System.out.println("Se esta horneando el : " + this.pan);
        this.disponible = true;
        notify();
    }

    public synchronized String consumir(){
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Clienbte se lleva el : " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}
