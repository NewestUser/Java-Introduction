package lecture14.exercises.task4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteDemo {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<String> data = new ArrayList<>();
        while (true) {

            System.out.print("Въведете текст: ");
            String input = scanner.nextLine();

            if ("stop".equalsIgnoreCase(input)) {
                break;
            }

            data.add(input);
        }

        File createdFile = createFile("echo.txt");

        PrintWriter writer = new PrintWriter(createdFile);

        for (String eachData : data) {
            writer.println(eachData);
        }

        writer.flush();
        writer.close();

        System.out.println("Проверете съдържанеието на echo.txt");
    }

    private static File createFile(String name) {
        File myFile = new File(name);

        try {
            myFile.createNewFile();
            return myFile;
        } catch (IOException e) {
            throw new RuntimeException("There was an error creating the file.", e);
        }
    }
}
