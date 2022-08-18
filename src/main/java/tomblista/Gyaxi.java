package tomblista;

import java.util.Arrays;

public class Gyaxi {

    public static void main(String[] args) {

        int[] something = {1,2,3,4};
        System.out.println(Arrays.toString(something));

        int[] empty = new int[2];
        System.arraycopy(something, 1, empty, 0, 2);
        System.out.println(Arrays.toString(empty));

    }
}
