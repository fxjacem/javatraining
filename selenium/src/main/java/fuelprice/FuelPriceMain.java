package fuelprice;

import java.util.Scanner;

public class FuelPriceMain {

    public static void main(String[] args) {

        String baseUrl = "https://holtankoljak.hu/";
        String queryUrl = "https://holtankoljak.hu/index.php?ua_map=1&uz_tip=%s&mycity=%s&myrad=%s#page_ad";

        FuelPrice program = new FuelPrice(baseUrl);

        Scanner scanner = new Scanner(System.in);

        program.fuelSelector();
        String fuelId = scanner.nextLine();

        System.out.print("Enter the name of the city: ");
        String cityName = scanner.nextLine();
        String cityId = program.getCityId(cityName);

        program.distanceSelector();
        String distanceId = scanner.nextLine();

        program.inquiryOfPrices(String.format(queryUrl, fuelId, cityId, distanceId));


        // program.inquiryOfPrices("https://holtankoljak.hu/index.php?ua_map=1&uz_tip=1&mycity=2853&myrad=10#page_ad");

        program.quitDriver();
    }
}
