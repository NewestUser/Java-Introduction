package lecture8;

public class CarDemo {

    public static void main(String[] args) {

        // използваме конструктора със задължителните полета
        Car bmw = new Car("BMW", 2010, true);

        bmw.printCarDetails();

        // използваме конструктора с всички полета
        Car ford = new Car("Ford", 2000, false, 220, "Green");
        ford.printCarDetails();

        bmw.changeColor("Red"); // сменяме цвета на bmw

        bmw.printCarDetails();
        ford.printCarDetails();
    }
}
