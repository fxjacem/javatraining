package tomblista.arrayofarrays;

public class ArrayOfArrays {

    public void printArrayOfArrays(int[][] a) {

        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int[][] numbers = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}};

        new ArrayOfArrays().printArrayOfArrays(numbers);

    }
}
