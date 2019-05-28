package lecture8.exercises.heiarchy;

public class Dog extends Animal {

    public String breed;

    Dog(String breed, int age) {
        this.breed = breed;
        this.age = age;
    }


    public void bark() {
        System.out.println("Woff woff...");
    }

    public void printDetailsAndEat() {
        // age е дефинирано в супер класът
        System.out.println("Breed: " + breed + " " + "Age: " + age);

        // този метод е дефиниран в супер класът
        eat();
    }
}
