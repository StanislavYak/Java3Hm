

public class Homework4 {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) throws InterruptedException {
        Homework4 hw = new Homework4();

        new Thread(() -> hw.printLetter('A', 'B', 5)).start();
        new Thread(() -> hw.printLetter('B', 'C', 5)).start();
        new Thread(() -> hw.printLetter('C', 'A', 5)).start();
        System.out.println();
    }

    private void printLetter(char mainLetter, char nextLetter, int times) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < times; i++) {
                    while (currentLetter != mainLetter)
                        monitor.wait();
                    System.out.print(mainLetter);
                    currentLetter = nextLetter;
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}