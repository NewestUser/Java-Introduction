package lecture8;

public class Car {

    // полета които са final (не могат да бъдат променяни)
    private final String model;
    private final int year;
    private final boolean isAutomatic;

    // полета които могат да бъдат променяни след инстанцирането
    private int maxSpeed;
    private static String color; // пробвайте със и без ключовата дума static

    Car(String model, int year, boolean isAutomatic) { // конструктор със задължителните полета
        this.model = model;
        this.year = year;
        this.isAutomatic = isAutomatic;
    }

    Car(String model, int year, boolean isAutomatic, int maxSpeed, String color) { // конструктор с всички полета
        this.model = model;
        this.year = year;
        this.isAutomatic = isAutomatic;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    /**
     * Методът примеа новия цвят на колата и го записва в property-то за цвят.
     * @param color новия цвят на колата
     */
    void changeColor(String color) {
        this.color = color;
    }

    /**
     * Този метод принтира детайлите на колата.
     * Като добавя отстояние на полето color, за да може по лесно да се наблюдава.
     */
    void printCarDetails() {
        System.out.println("===============");
        System.out.println("model: " + model);
        System.out.println("year: " + year);
        System.out.println("isAutomatic: " + isAutomatic);
        System.out.println("maxSpeed: " + maxSpeed);
        System.out.println("color: " + color);
    }
}
