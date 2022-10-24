package sortintreemap;

import java.text.Collator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortInTreeMap {

    public static void main(String[] args) {

        List<String> input = Arrays.asList("Á", "A", "É", "E", "Í", "I",
                "Ó", "O", "Ő", "Ö", "Ú", "U", "Ű", "Ü");
        System.out.println(String.join(", ", input));

        Map<String, Integer> vowels = input.stream()
                .collect(Collectors.toMap(Function.identity(), x -> (int)x.charAt(0)));

        Map<String, Integer> hungarianVowels = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));
        hungarianVowels.putAll(vowels);

        vowels.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));
        hungarianVowels.forEach((key, value) -> System.out.println("hun_Key : " + key + " Value : " + value));

        System.out.println();
        System.out.println(vowels.getClass());
        System.out.println(hungarianVowels.getClass());
    }
}
