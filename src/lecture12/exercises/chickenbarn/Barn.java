package lecture12.exercises.chickenbarn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Barn {

    private List<Chicken> chickens;
    private List<Egg> eggs;

    /**
     * Конструктор, който инициализира фермата с подадените през него кокошки.
     * Когато се създаде нова ферма, в нея няма яйца.
     *
     * @param chickens първоначалните кокошки във фермата.
     */
    public Barn(List<Chicken> chickens) {
        this.chickens = chickens;
        this.eggs = new ArrayList<>();
    }

    /**
     * Този метод еволюира фермата с определен брой седмици.
     *
     * @param weeks броя седмици, с които да бъде еволюирана фермата.
     * @return връща списъкът с кокошки след еволюцията.
     */
    public List<Chicken> evolve(int weeks) {

        for (int week = 0; week < weeks; week++) {

            hatchEggs();

            growChickens();
        }

        return chickens;
    }

    /**
     * Този метод репрезентира, какво се случва през една седмица с яйцата.
     * Методът обикаля всички налични яйца, увеличава им възрастта с 1 седмица,
     * излюпва яйцата, които са годни и добавя излюпените кокошки в списъка с кокошки.
     */
    private void hatchEggs() {
        Iterator<Egg> iterator = eggs.iterator();

        while (iterator.hasNext()) {

            Egg currentEgg = iterator.next();

            currentEgg.ageByOneWeek();
            Chicken newChicken = currentEgg.hatch();

            if (newChicken != null) {
                chickens.add(newChicken);

                iterator.remove();
            }

        }
    }

    /**
     * Този метод репрезентира, какво се случва през една седмица с кокошките.
     * Методът обикаля всички налични кокошки, увеличава им възрастта с 1 седмица
     * Премахва кокошките на преклонна възраст и снася яйца използвайки кокошките на зряла възраст,
     * като добавя излюпените яйца в списъка с яйца..
     */
    private void growChickens() {
        Iterator<Chicken> iterator = chickens.iterator();

        while (iterator.hasNext()) {
            Chicken currentChicken = iterator.next();

            currentChicken.ageByOneWeek();

            if (currentChicken.canDie()) {
                iterator.remove();
            }

            Egg egg = currentChicken.hatchEgg();
            if (egg != null) {
                eggs.add(egg);
            }
        }

    }
}
