package test;

import java.util.Timer;
import java.util.TimerTask;

class Task extends TimerTask {

    int counter;

    public Task() {
        counter = 0;
    }

    @Override
    public void run() {
        counter++;
        System.out.println("Ring " + counter);
    }

    public int getCount() {
        return counter;
    }
}

public class TimerTest {

    private boolean running;
    private Task task;
    private Timer timer;

    public TimerTest() {
        timer = new Timer(true);
    }

    public boolean isRinging() {
        return running;
    }

    public void startRinging() {
        running = true;
        task = new Task();
        timer.scheduleAtFixedRate(task, 0, 3000);
    }

    public void doIt() {
        running = false;
        System.out.println(task.getCount() + " times");
        task.cancel();
    }

    public static void main(String args[]) {
        TimerTest phone = new TimerTest();
        phone.startRinging();
        try {
            System.out.println("started running...");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }
        phone.doIt();
    }
}
