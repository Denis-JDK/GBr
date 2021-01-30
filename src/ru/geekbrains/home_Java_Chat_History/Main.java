package ru.geekbrains.home_Java_Chat_History;

public class Main {
    private static final Object moon = new Object();



    public static void main(String[] args) {

       new  ExecutorEx();

      /*  new Thread(() -> {
            synchronized (moon) {
                try {
                    System.out.println("A");
                    moon.wait();
                    System.out.println("A");
                    moon.wait();
                    System.out.println("A");
                    moon.wait();
                    System.out.println("A");
                    moon.wait();
                    System.out.println("A");
                    moon.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (moon) {
                try {
                    System.out.println("B1");
                    moon.wait();
                    Thread.sleep(200);
                    System.out.println("B2");
                    moon.wait();
                    Thread.sleep(200);
                    System.out.println("B3");
                    moon.wait();
                    Thread.sleep(200);
                    System.out.println("B4");
                    moon.wait();
                    Thread.sleep(200);
                    System.out.println("B5");
                    moon.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    new Thread(() -> {

        synchronized (moon) {
            try {
                System.out.println("C");
                moon.notifyAll();
                moon.wait(1000);
                System.out.println("C");
                moon.notify();
                moon.notifyAll();
                moon.wait(1000);
                System.out.println("C");
                moon.notifyAll();
                moon.wait(1000);
                System.out.println("C");
                moon.notifyAll();
                moon.wait(1000);
                System.out.println("C");
                moon.notifyAll();
                moon.wait(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();*/

    }
}
