package lecture7.exercises.task2;

public class Person {
    String name;
    int age;
    boolean isWoman;

    void eat() {
        System.out.println("Eating...");
    }

    void growUp() {
        age++;
    }

    void drinkWater(double liters) {
        if (liters > 1) {
            System.out.println("This is too much water!");
        } else {
            System.out.printf("%s is drinking %.2f liters of watter", name, liters);
        }
    }

    int calculateAge(int years) {
        return age + years;
    }
}
