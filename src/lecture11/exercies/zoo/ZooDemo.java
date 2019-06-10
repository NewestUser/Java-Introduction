package lecture11.exercies.zoo;

public class ZooDemo {

    public static void main(String[] args) {

        Animal bird = new Bird();
        Animal cat = new Cat();
        Animal dog = new Dog();
        Animal persianCat = new PersianCat();

        Zoo zoo = new Zoo();

        zoo.add(bird);
        zoo.add(cat);
        zoo.add(dog);
        zoo.add(persianCat);

        zoo.feedAnimals();
    }

}
