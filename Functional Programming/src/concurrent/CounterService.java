package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class CounterService {
    public static int cont = 0;

    private static final ReentrantLock candado = new ReentrantLock();

    //synchronized sirve solo cuando es la misma instancia, si son diferentes no funciona
    //Para una instancia diferente se utiliza ReentrantLock
    /*public synchronized void aumentar(){
        this.cont++;
    }*/

    public void aumentar(){
        candado.lock();
        cont++;
        candado.unlock();
    }


}
