package lecture12.exercises.chickenbarn;

public class Egg {

    private static final int HATCHING_WEEK = 2;

    private String chickenName;
    private int age;

    /**
     * Конструктор, за създаванен на ново яйце.
     *
     * @param chickenName името на кокошката снесла яйцето.
     */
    public Egg(String chickenName) {
        this.chickenName = chickenName;
        age = 0;
    }

    /**
     * Увеличи възрастта на яйцето с 1 седмица.
     */
    public void ageByOneWeek() {
        age++;
    }

    /**
     * Излюпи яйцето, ако е навършило необходимата възраст.
     *
     * @return излюпената кокоша или null, ако яйцето не може да бъде излюпено.
     */
    public Chicken hatch() {

        if (age < HATCHING_WEEK) {
            return null;
        }

        return new Chicken(chickenName);
    }
}
