package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Experimentation {

    public static void main(String[] args) {

        new Experimentation().main();
    }

    public void main() {
        List<String> names = new ArrayList<>(Arrays.asList("John Doe", "Jack Doe", "Jane Doe"));

        System.out.println(Collections.unmodifiableList(names));
        names.replaceAll(this::reverseText);
        names.replaceAll(this::capitalize);
        System.out.println(names);


    }

    public  String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public  void printReverseText(String text) {
        System.out.println(new StringBuilder(text).reverse().toString());
    }

    public String capitalize(String text) {
        StringBuilder sb = new StringBuilder();

        String[] parts = text.split(" ");
        for (String part : parts) {
            String temp = part.toLowerCase();
            sb.append(temp.substring(0, 1).toUpperCase() + temp.substring(1) + " ");
        }

        return sb.toString().strip();
    }
}
