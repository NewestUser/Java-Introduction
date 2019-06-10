package lecture11.exercies.polymorphism;

public class Airplane implements Flyer {

    @Override
    public void fly() {
        System.out.println("Starting engines");
    }
}
