package lecture12.exercises.chickenbarn;

public class Chicken {

    private static final int DEATH_WEEK = 9;
    private static final int MIN_HATCH_WEEK = 2;
    private static final int MAX_HATCH_WEEK = 8;

    /* Статична променлива, която се използва в името на кокошката.
     * Всеки път, когато се създаде нова кокошка, тази променлива се увеличава с 1.
     */
    private static int ID_SEQUENCE = 1;

    private final String name;

    private int age;

    /**
     * Създай нова кокошка назначавайки и служебно име и подадаената възраст.
     *
     * @param age възрастта на кокошката в седмици.
     */
    public Chicken(int age) {
        this.name = getNextName("");
        this.age = age;
    }

    /**
     * Конструктор създадващ новородена кокошка. Конструкторът приема името на кокошката, която е снесла
     * яйцето. На база това име ще се определи името на тази кокошка.
     *
     * @param chickenName името на кокошката снесла яйцето.
     */
    public Chicken(String chickenName) {
        this.name = getNextName(chickenName + "/");
        this.age = 0;
    }

    /**
     * Метод връщащ името на кокошката съставено от prefix + "Chicken" + ID, където ID е поредния
     * номер на кокошката.
     *
     * @param prefix текст, който да бъде използван пред името на кокошката.
     * @return ново име на кокошка.
     */
    private String getNextName(String prefix) {
        return prefix + "Chicken" + ID_SEQUENCE++;
    }

    /**
     * Този метод проверява дали кокошката е навършила необходимата възраст за да умре.
     *
     * @return true ако е навършила преклонна възраст, false в противен случай.
     */
    public boolean canDie() {
        return age >= DEATH_WEEK;
    }

    /**
     * Този метод връща яйце, ако кокошката е навършила зряла възраст и може да снася яйца.
     * Снесеното яйце има името на кокошката, която го е снесла.
     *
     * @return снесеното яйце или null ако кокошката не може да снася.
     */
    public Egg hatchEgg() {
        if (age < MIN_HATCH_WEEK || age > MAX_HATCH_WEEK) {
            return null;
        }

        return new Egg(name);
    }

    /**
     * Този метод увеличава възрастта на кокошката с една седмица.
     */
    public void ageByOneWeek() {
        this.age++;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                '}';
    }
}
