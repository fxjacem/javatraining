package tomblista.arrays;

import java.util.Arrays;

public class ArraysMain {

    public String numberOfDaysAsString() {

        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 30, 31, 30, 31, 30, 31};

        return Arrays.toString(numberOfDays);
    }

    public String multiplicationTableAsString(int size) {

        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return Arrays.deepToString(table);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {

        return Arrays.equals(day, anotherDay);
    }

    public boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {

        return true;
    }

    public static void main(String[] args) {

        System.out.println(new ArraysMain().multiplicationTableAsString(3));
    }
}
