package ru.hm.hm5;

import static ru.hm.hm5.Race.CARS_COUNT;
import static ru.hm.hm5.Race.START;

public class Homework5 {
        public static void main(String[] args) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            }
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
            try{
                START.await();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }




