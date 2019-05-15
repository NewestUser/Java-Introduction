package lecture6;

public class Main {

    public static void main(String[] args) {
        Car peugeot = new Car();

        peugeot.model = "Peugeot";
        peugeot.color = "Green";
        peugeot.currentGear = 0;
        peugeot.currentSpeed = 0;
        peugeot.maxSpeed = 220;

        Person gosho = new Person();
        gosho.name = "Gosho";
        gosho.age = 30;

        Person pesho = new Person();
        pesho.name = "Pesho";
        pesho.age = 40;

        gosho.friend = pesho;

        peugeot.owner = gosho;

        System.out.printf("Приятелят на %s с име %s има %s с цвят %s и максимална скорост %d\n",
                peugeot.owner.friend.name,
                peugeot.owner.name,
                peugeot.model,
                peugeot.color,
                peugeot.maxSpeed
        );

        System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);
        peugeot.speedUp();
        peugeot.speedUp();
        System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);

        peugeot.shiftUp();
        peugeot.shiftUp();
        System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);

        peugeot.speedDown();
        System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);

        peugeot.stop();
        System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);
    }
}
