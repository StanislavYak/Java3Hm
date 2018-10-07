package ru.hm.hm5;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {
    static final Object WINNER_MONITOR = new Object();
    private List<Stage> stages;

    List<Stage> getStages(){
        return stages;
    }

    public Race(Stage... stages){
        this.stages = Arrays.asList(stages);
    }
    static final int CARS_COUNT = 4;
    static final CountDownLatch START = new CountDownLatch(CARS_COUNT);
    static final CyclicBarrier FINISH = new CyclicBarrier(CARS_COUNT,()->
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!"));
    static AtomicInteger results = new AtomicInteger(0);


    }
