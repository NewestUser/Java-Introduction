package lecture11.exercies.polymorphism;

public class Bird implements Flyer {

    @Override
    public void fly() {
        System.out.println("Flap wings");
    }
}
