package lecture11.exercies.polymorphism;

public class Main {

    public static void main(String[] args) {
        Flyer bird = new Bird();
        Flyer airplane = new Airplane();

        startFlying(bird); // Bird приема формата на Flyer
        startFlying(airplane); // Airplane приема формата на Flyer
    }

    /**
     * Този метод приема {@link Flyer}.
     * Той е абстрахиран от {@link Bird} и {@link Airplane}.
     *
     * @param flyer инстанция, която ще полети.
     */
    private static void startFlying(Flyer flyer) {
        if (flyer instanceof Bird) {
            Bird bird = (Bird) flyer;
            bird.fly();
        }
    }
}
