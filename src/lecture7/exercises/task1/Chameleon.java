package lecture7.exercises.task1;

public class Chameleon {
    String color;
    double weight;

    /**
     * Change the color of the chameleon. If the desired color is gray then the color won't be changed.
     *
     * @param color the new color of the chameleon.
     */
    void changeColor(String color) {
        if ("gray".equals(color)) {
            return;
        }

        this.color = color;
    }

}
