package ru.geekbrains.home_Java_Chat_History;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private long finishTime;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c, int stagePos, int stageCount, long startTime) {
        Semaphore semaphore = new Semaphore(MainClass.CARS_COUNT /2);
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finishTime = System.currentTimeMillis() - startTime;
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
                if (stagePos == stageCount && MainClass.firstFinish) {
                    MainClass.firstFinish = false;
                    System.out.println(c.getName() + " Победил");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
