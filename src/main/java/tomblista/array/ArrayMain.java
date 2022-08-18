package tomblista.array;

import java.util.Arrays;

public class ArrayMain {

    public static void main(String[] args) {

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println(days[1]);
        System.out.println(days.length);

        int[] kettoHatvanyai = new int[5];
        kettoHatvanyai[0] = 1;
        System.out.print(kettoHatvanyai[0] + " ");
        for (int i = 1; i < kettoHatvanyai.length; i++) {
            kettoHatvanyai[i] = kettoHatvanyai[i-1] * 2;
            System.out.print(kettoHatvanyai[i] + " ");
        }

        boolean[] values = new boolean[6];
        values[0] = false;
        for (int i = 1; i < values.length; i++) {
            values[i] = !values[i-1];
        }
        for (boolean value: values) {
            System.out.print(value + " ");
        }

        System.out.println(Arrays.toString(kettoHatvanyai));
        System.out.println(Arrays.toString(values));
    }
}
