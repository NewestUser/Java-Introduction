package lecture8.exercises.heiarchy;

public class Cat extends Animal {

    public int numberOfLives;

    public void purr() {
        System.out.println("PurRrRr...");
    }

    public void printDetailsAndEat() {
        // age е дефинирано в супер класът
        System.out.println("Num of Lives: " + numberOfLives + " " + "Age: " + age);

        // този метод е дефиниран в супер класът
        eat();
    }
}
