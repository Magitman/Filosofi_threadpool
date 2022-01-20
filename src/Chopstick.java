public class Chopstick {
    private Philosopher filosofo;
    private static int counter = 0;
    private int number = counter++;

    public synchronized void grab(Philosopher p) {
        try {
            while (filosofo != null) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Error in class \"Chopstick\". Message: " + e.getMessage());
        }
        this.filosofo = p;
    }

    public synchronized void release(Philosopher p) {
        if (this.filosofo == p) {
            this.filosofo = null;
        }
        notify();
    }

    @Override
    public String toString() {
        return "Chopstick number: " + this.number;
    }
}
