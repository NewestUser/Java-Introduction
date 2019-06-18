package lecture12.exercises.chickenbarn;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Chicken> chickens = new ArrayList<>();

        chickens.add(new Chicken(3));
        chickens.add(new Chicken(4));
        chickens.add(new Chicken(5));

        Barn barn = new Barn(chickens);

        List<Chicken> evolvedChickens = barn.evolve(4);

        for (Chicken chicken : evolvedChickens) {
            System.out.println(chicken);
        }
    }
}
