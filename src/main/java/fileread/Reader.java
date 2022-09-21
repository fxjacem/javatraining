package fileread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {

    public static void main(String[] args) {

        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/ezt.txt"));
            System.out.println(lines);

            lines = Files.readAllLines(Paths.get("src/main/resources/school.csv"));
            System.out.println(lines);
        } catch (IOException e) {
            throw new IllegalStateException("HIBA", e);
        }

    }
}
