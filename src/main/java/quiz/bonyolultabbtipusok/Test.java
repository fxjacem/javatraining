package quiz.bonyolultabbtipusok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {

        System.out.println(new Random().nextInt(5) + 1);

        int[] numbers = {2, 6, 3, 9, 10, 4};
        int [] secondPart = Arrays.copyOfRange(numbers, 3, 6);
        System.out.println(Arrays.toString(secondPart));

        System.out.println(Math.sqrt(2));

        List<Integer> numbers2 = Arrays.asList(1, 1, 1);
        System.out.println(numbers2);

        System.out.println(Arrays.toString(args));

        List<Integer> heights = new ArrayList<>();
        heights.add(0, 1974);
        System.out.println(heights);


    }
}
