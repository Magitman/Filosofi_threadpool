public class Philosopher extends Thread {
    private Chopstick leftChop, rightChop;
    private static int counter = 0;
    private int number = counter++;

    public Philosopher(Chopstick left, Chopstick right) {
        this.leftChop = left;
        this.rightChop = right;
        start();
    }

    private synchronized void think() {
        System.out.println(this + "\tStart thinking");
        try {
            sleep((long) Math.random() * 1000);
        } catch (InterruptedException e) {
            System.out.println("Error in class \"Philosopher\". Message: " + e.getMessage());
        }
    }

    private synchronized void eat() {
        System.out.println(this + " waiting for left chopstick..." + this.rightChop.chopstickNumber());
        synchronized (this.leftChop) {
            System.out.println(this + " just got the left chop");
            System.out.println(this + " waiting for right chopstick..." + this.rightChop.chopstickNumber());
            synchronized (this.rightChop) {
                try {
                    System.out.println(this + "\tEating...");
                    sleep((long) Math.random() * 1000);
                } catch (InterruptedException e) {
                    System.out.println("Error in class \"Philosopher\". Message: " + e.getMessage());
                }
                System.out.println(this + " released right chopstick " + this.rightChop.chopstickNumber());
            }
            System.out.println(this + " released left chopstick " + this.rightChop.chopstickNumber());
        }
    }

    @Override
    public void run() {
        int index = 0;
        while (index < 4) {
            this.eat();
            this.think();
            index++;
        }
    }

    @Override
    public String toString() {
        return "Philosopher number: " + this.number;
    }
}
