public class Philosopher extends Thread {
    private Chopstick leftChop, rightChop;
    private static int counter = 0;
    private int number = counter++;

    public Philosopher(Chopstick left, Chopstick right) {
        this.leftChop = left;
        this.rightChop = right;
        start();
    }

    private void think() {
        System.out.println(this + "\tStart thinking");
        try {
            sleep((long)Math.random()*1000);
        } catch (InterruptedException e) {
            System.out.println("Error in class \"Philosopher\". Message: " + e.getMessage());
        }
    }

    private void eat() {
        this.leftChop.grab(this);
        this.rightChop.grab(this);

        try {
            sleep((long)Math.random()*1000);
        } catch (InterruptedException e) {
            System.out.println("Error in class \"Philosopher\". Message: " + e.getMessage());
        }
        System.out.println(this + "\tFinished eating!");

        this.rightChop.release(this);
        this.leftChop.release(this);
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
