package fuelprice;

import java.util.Scanner;

public class FuelPriceMain {

    public static void main(String[] args) {

        FuelPrice program = new FuelPrice();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a várost");

        program.distancesList();

        String city = scanner.nextLine();


        program.quitDriver();
    }
}
