package lecture11.exercies.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        this.animals.add(animal);
    }

    public void feedAnimals() {
        for (Animal animal : animals) {

            if (animal instanceof PersianCat) { // проверяваме дали животното е PersianCat
                PersianCat persianCat = (PersianCat) animal; // кастваме Animal към PersianCat
                persianCat.play();
            }

            animal.eat();
        }
    }
}
