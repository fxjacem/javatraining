package sortintreemap;

import java.text.Collator;
import java.util.*;

public class Student {

    public static void main(String[] args) {

        Map<String, Integer> students = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));
        students.put("Elemér Péter", 177);
        students.put("Albert Aladár", 166);
        students.put("Áder János", 159);
        students.put("Ónodi Ferenc", 180);
        students.put("Éles Róbert", 189);

        System.out.println(students);

        for (Map.Entry<String, Integer> actual : students.entrySet()) {
            System.out.println(actual.getKey() + ": " + actual.getValue());
        }

        String[] letters = {"A", "Á", "B", "C", "Cs", "D", "Dz", "Dzs", "E", "É", "F", "G", "Gy",
                "H", "I", "Í", "J", "K", "L", "Ly", "M","N", "Ny", "O", "Ó", "Ö", "Ő", "P", "Q",
                "R", "S", "Sz", "T", "Ty", "U", "Ú", "Ü", "Ű", "V", "W", "X", "Y", "Z", "Zs"};

        Map<String, Integer> letterId = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));
        for (int i = 0; i < letters.length; i++) {
            letterId.put(letters[i], i + 1);
        }
        System.out.println(letterId);


    }
}
