package ru.hm.hm5;

import java.util.concurrent.BrokenBarrierException;

import static ru.hm.hm5.Race.*;

public class Car implements Runnable {
    private static int CARS_COUNT = 0;

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            START.countDown();
            START.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        synchronized (WINNER_MONITOR) {
            int position = results.incrementAndGet();
            System.out.println(position == 1 ? getName() + " - WIN" : getName() + " - занял " + position + " место");
        }
        try {
            FINISH.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }


    }
}