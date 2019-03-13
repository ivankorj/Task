package by.epam.learn.ship;

import by.epam.learn.port.Port;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Ship extends Thread {

    private static Port port = new Port(5, 1000);

    private static boolean[] flagPier = new boolean[port.getPlaceCount()];

    private static Semaphore semaphore = new Semaphore(port.getPlaceCount(), true);

    private static int currentNumContainsInPort = 0;

    private int idShip;
    private int currentNumOfContainsInShip;
    private int maxNumOfContainsInShip;
    private ReentrantLock locker;

    public Ship(int idShip, int currentNumOfContainsInShip, int maxNumOfContainsInShip, ReentrantLock locker) {
        this.idShip = idShip;
        this.currentNumOfContainsInShip = currentNumOfContainsInShip;
        this.maxNumOfContainsInShip = maxNumOfContainsInShip;
        this.locker = locker;
    }

    @Override
    public void run() {
        if (currentNumOfContainsInShip >= 0) {
            if (currentNumOfContainsInShip <= maxNumOfContainsInShip) {
                if (currentNumOfContainsInShip <= port.getMaxNumOfContainersInPort()) {
                    System.out.println("Ship №" + idShip + " sailed to the pier");
                    try {
                        semaphore.acquire();
                        int pierNumber = -1;
                        locker.lock();
                        try {
                            if ((currentNumContainsInPort + currentNumOfContainsInShip) <= port.getMaxNumOfContainersInPort()) {
                                for (int i = 0; i < 5; i++) {
                                    if (!flagPier[i]) {
                                        flagPier[i] = true;
                                        pierNumber = i;
                                        currentNumContainsInPort += currentNumOfContainsInShip;
                                        System.out.println("Ship №" + idShip + " moored at the pier " + (i + 1));
                                        System.out.println("Current number of containers in port: " + currentNumContainsInPort);
                                        break;
                                    }
                                }
                            } else System.out.println("There is no space in the port for unloading ship №" + idShip);
                        } finally {
                            locker.unlock();
                        }
                        Thread.sleep(3000);
                        locker.lock();
                        try {
                            flagPier[pierNumber] = false;
                        }
                        catch(ArrayIndexOutOfBoundsException ignored){

                        }
                        finally {
                            locker.unlock();
                        }
                        semaphore.release();
                        System.out.println("Ship №" + idShip + " left port");
                    } catch (InterruptedException ignored) {}
                } else System.out.println("Ship №" + idShip + " can not moor, because there is no place in the port");
            } else System.out.println("Ship №" + idShip + " drowned due to overload");
        } else System.out.println("Ship №" + idShip + " has a negative number of containers");
    }
}