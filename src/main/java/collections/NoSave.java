package collections;

import java.text.Collator;
import java.util.*;

public class NoSave {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Joe", "Jack", "Jane", "Joshua", "Jackson", "Ja");
        System.out.println(names);

        Collections.sort(names);
        System.out.println(names);

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(names);

        List<Trainer> trainers = Arrays.asList(
                new Trainer("Joe", 3),
                new Trainer("Jack", 2),
                new Trainer("Jane", 1)
        );
        System.out.println(trainers);

        Collections.sort(trainers);
        System.out.println(trainers);

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return Integer.compare(o1.getSalary(), o2.getSalary());
            }
        });
        System.out.println(trainers);

        Collections.sort(names, Collator.getInstance(new Locale("hu", "HU")));
        System.out.println(names);

//        Collections.sort(trainers, Collator.getInstance(new Locale("hu", "HU")));
//        System.out.println(trainers);

        Collections.sort(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(trainers);

        System.out.println(trainers.contains(new Trainer("Joe", 3)));
        System.out.println(names.containsAll(Arrays.asList("Joe", "Jack")));
        System.out.println(names.contains("Joe"));
        System.out.println(names.indexOf("Jack"));
        System.out.println(names.indexOf("Q"));

        int[] i = {1, 2, 3, 4, 5, 6, 7, 0};
        Arrays.sort(i);
        System.out.println(Arrays.binarySearch(i, 5));

        List<Integer> l = Arrays.asList(1, 3, 5, 6, 7, 9, 12);
        Collections.min(l);


        Trainer min = Collections.min(trainers, new Comparator<Trainer>() {
            @Override
            public int compare(Trainer o1, Trainer o2) {
                return Integer.compare(o1.getSalary(), o2.getSalary());
            }
        });

        System.out.println(min);

        List<String> names2 = Arrays.asList("Joe", "Jane", "Jack", "Jossy");
        System.out.println(names2);
        System.out.println(Collections.binarySearch(names2, "Jack"));
        System.out.println(Collections.binarySearch(names2, "Jack", new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }));

    }
}
