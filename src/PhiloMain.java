import java.util.ArrayList;
import java.util.List;

public class PhiloMain {
    public static void main(String[] args) {
        final int numPhilosophers = 5;
        List<Philosopher> filosofi = new ArrayList<>();

        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();
        Chopstick first = left;

        filosofi.add(new Philosopher(left, right));
        for (int index = 0; index < numPhilosophers-2; index++) {
            left = right;
            right = new Chopstick();
            filosofi.add(new Philosopher(left, right));
        }

        filosofi.add(new Philosopher(first, left));
    }
}
