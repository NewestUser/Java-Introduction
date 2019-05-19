package lecture6.homework.task2;

public class Computer {

    int year;
    int price;
    boolean isNotebook;
    long hardDiskMemory;
    long freeMemory;
    String operatingSystem;

    void changeOperatingSystem(String newOperatingSystem) {
        operatingSystem = newOperatingSystem;
    }

    void useMemory(long memory) {
        if (freeMemory < memory) {
            System.out.println("Not enough memory!");
        } else {
            freeMemory -= memory;
        }
    }
}
