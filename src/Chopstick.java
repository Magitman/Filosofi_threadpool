public class Chopstick {
    private static int counter = 0;
    private int number = counter++;

    public int chopstickNumber () {
        return this.number;
    }

    @Override
    public String toString() {
        return "Chopstick number: " + this.number;
    }
}
