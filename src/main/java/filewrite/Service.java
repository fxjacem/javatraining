package filewrite;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static final Path path = Path.of("src/main/resources/taxes.txt");

    private static final List<Tax> taxes = new ArrayList<>();

    public static void main(String[] args) {

        Service service = new Service();
        taxes.add(new Tax("12345", 100));
        taxes.add(new Tax("54321", 200));
        taxes.add(new Tax("11223", 300));
        taxes.add(new Tax("12321", 400));

        service.writeTaxesToFile();
        service.writeWithPrintWriter();
    }

    private void writeTaxesToFile() {
        List<String> output = taxes.stream()
                .map(Tax::toString)
                .toList();

        try {
            Files.write(path, output);
        } catch (IOException ioe) {
            throw new IllegalStateException("File write error!", ioe);
        }
    }

    private void writeWithPrintWriter() {
        try {
            PrintWriter output = new PrintWriter("src/main/resources/taxes_pw.txt");
            output.print(taxes);
            output.close();
        } catch (IOException ioe) {
            throw new IllegalStateException("File write error!", ioe);
        }
    }

}
