package lecture14.exercises.task1;

import java.io.File;

public class Task1 {

    public static void main(String[] args) {
        File file = new File("iotest");

        if (!file.exists()) {
            file.mkdir();
        }

        for (String name : file.list()) {
            System.out.println(name);
        }
    }
}
