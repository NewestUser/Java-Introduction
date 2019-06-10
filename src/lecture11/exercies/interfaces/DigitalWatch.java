package lecture11.exercies.interfaces;

public class DigitalWatch implements Watch {

    @Override
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
