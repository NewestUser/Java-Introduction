package lecture6.exercise;

public class Car {

    String model;
    String color;
    int currentGear;
    int maxSpeed;
    int currentSpeed;

    Person owner;

    /**
     * Този метод моделира качването на предавка, като максималната възможна предавка е 5.
     * Всеки път когато се вдигне предавка скоростта се увеличава.
     */
    void shiftUp() {
        if (currentGear < 5) {
            currentGear++;

            speedUp(); // увеличи скоростта
        }
    }

    /**
     * Този метод моделира смъкването на предавка, като минималната възможна предавка е 0.
     * При всяко смъкване на предавка се намалява скоростта.
     */
    void shiftDown() {
        if (currentGear == 0) {
            return; // не дей да правиш нищо защото вече сме на нулева предавка.
        }

        currentGear--;
        speedDown(); // намали скоростта
    }

    /**
     * Този метод моделира намаляването на текущата скорост. При извикването на метода текущата скорост
     * се намалява с 10 до достигането на нулева скорост.
     */
    void speedDown() {
        int nextSpeed = currentSpeed - 10;

        if (nextSpeed >= 0) {
            currentSpeed = nextSpeed;
        }
    }

    /**
     * Този метод моделира увеличаването на скоростта, като към текущата скорост добавя 10.
     * Ако сме на 0-ва предавка превключваме на 1-ва.
     */
    void speedUp() {
        if (currentGear == 0) {
            currentGear = 1; // ако сме биле на нулева предавка, превключи на 1-ва.
        }

        int nextSpeed = currentSpeed + 10;

        if (nextSpeed < maxSpeed) {
            currentSpeed = nextSpeed; // запиши новата скорост
        }
    }

    /**
     * Този метод моделира спирането на колата, като за currentSpeed записва 0.
     * Aко сме на по висока предавка намаляме предавката всеки път докато стигнем 0-ва предавка.
     */
    void stop() {
        for (int i = currentGear; i >= 0; i--) { // смъкни от текущата до нулева предавка
            shiftDown(); // смъкни предавка
        }

        currentSpeed = 0; // занули остатъчната скорост
    }
}
