package tomblista.array;

import java.util.Arrays;

public class ArrayHandler {

    public void addIndexToNumber(int[] source) {

        for (int i = 0; i < source.length; i++) {
            source[i] += i;
        }
    }

    public void concatenateIndexToWord(String[] source) {

        for (int i = 0; i< source.length; i++) {
            source[i] = i + ". " + source[i];
        }
    }

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};
        String[] words = {"egy", "kettő", "három", "négy", "öt"};

        System.out.println(Arrays.toString(numbers));
        new ArrayHandler().addIndexToNumber(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.toString(words));
        new ArrayHandler().concatenateIndexToWord(words);
        System.out.println(Arrays.toString(words));

    }
}
