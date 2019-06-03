package lecture10.singleton;

public final class Universe {

    // статична final инстанция
    private static Universe INSTANCE;

    // private конструктор, за да не може друг да инстанцира този клас
    private Universe() {
    }

    /**
     * Метод, който предоставя единствената инстанция на този клас.
     * Инстанцията ще бъде създадена при първото извикване на този метод.
     *
     * @return единствената инстанция на този клас.
     */
    public static Universe getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Universe();
        }

        return INSTANCE;
    }
}
