package by.epam.learn.main;

import by.epam.learn.ship.Ship;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock locker = new ReentrantLock();

        new Ship(1, 10, 100, locker).start();
        Thread.sleep(400);
        new Ship(2, 20, 100, locker).start();
        Thread.sleep(400);
        new Ship(3, 30, 100, locker).start();
        Thread.sleep(400);
        new Ship(4, 40, 100, locker).start();
        Thread.sleep(400);
        new Ship(5, 50, 100, locker).start();
        Thread.sleep(400);
        new Ship(6, 60, 3000, locker).start();
        Thread.sleep(400);
        new Ship(7, 70, 100, locker).start();
        Thread.sleep(400);
        new Ship(8, 80, 100, locker).start();
        Thread.sleep(400);
        new Ship(9, 90, 100, locker).start();
        Thread.sleep(400);
        new Ship(10, 100, 100, locker).start();
        Thread.sleep(400);
    }
}