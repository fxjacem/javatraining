package fuelprice;

import fuelprice.lists.Cities;
import fuelprice.lists.Distances;
import fuelprice.lists.FuelTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FuelPrice {

    private final static String VALUE = "value";
    private WebDriver driver;

    private List<FuelTypes> fuelTypes = new ArrayList<>();

    private List<Cities> cities = new ArrayList<>();
    private List<Distances> distances = new ArrayList<>();

    public FuelPrice(String baseUrl) {
        driver = initDriver(baseUrl);
        setLists();
    }

    public void inquiryOfPrices(String queryUrl) {
        System.out.println("queryUrl= " + queryUrl);
        driver.get(queryUrl);

        List<WebElement> table = driver.findElements(By.xpath("//*[@id=\"tavolsag\"]/table/tbody/tr"));
        System.out.println(table.size());

        for (int i = 1; i < 5; i++){
            WebElement tableRow = table.get(i);
            String query = String.format("//*[@id=\"tavolsag\"]/table/tbody/tr[%d]/td[2]/", i);
            String price = tableRow.findElement(By.xpath(query+"strong")).getText();
            WebElement span = tableRow.findElement(By.xpath(query+"span/a"));
            String link = span.getAttribute("href");
            String title = span.getText();
            System.out.println(price + " - " + link + " - " + title.trim());

            // price: //*[@id="tavolsag"]/table/tbody/tr[1]/td[2]/strong
            // address: //*[@id="tavolsag"]/table/tbody/tr[1]/td[2]/span/a
            // #tavolsag > table > tbody > tr:nth-child(1) > td:nth-child(2) > span > a
            //*[@id="tavolsag"]/table/tbody/tr[1]/td[2]

        }
    }
    public void distanceSelector() {
        String formatDistance = "%3s - %s" + System.lineSeparator();
        System.out.println("Selectable distances:");
        for (Distances actual : distances) {
            System.out.printf(formatDistance, actual.getDistanceId(), actual.getDistanceName());
        }
        System.out.print("Choose a distance: ");
    }

    public void fuelSelector() {
        String formatFuel = "%3s - %s" + System.lineSeparator();
        System.out.println("Optional fuels:");
        for (FuelTypes actual : fuelTypes) {
            System.out.printf(formatFuel, actual.getFuelTypeId(), actual.getFuelTypeName());
        }
        System.out.print("Choose fuel: ");
    }

    public String getCityId (String cityName) {

        for (Cities actual : cities) {
            if(actual.getCityName().equals(cityName)) {
                return actual.getCityId();
            }
        }

        return null;
    }
    public void quitDriver() {
        driver.quit();
    }
    private WebDriver initDriver(String baseUrl) {
        driver = new ChromeDriver();

        driver.get(baseUrl);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]"));
        submitButton.click();

        return driver;
    }

    private void setLists() {
        addFuelTypes();
        addCities();
        addDistances();
    }

    private void addFuelTypes() {
        // https://www.selenium.dev/documentation/webdriver/elements/select_lists/
        System.out.println("Collection: fuel type");
        WebElement selectElement = driver.findElement(By.name("uz_tip"));
        Select selectObject = new Select(selectElement);
        List<WebElement> allAvailableOptions = selectObject.getOptions();

        for (int i = 1; i < allAvailableOptions.size(); i++){
            WebElement actual = allAvailableOptions.get(i);
            fuelTypes.add(new FuelTypes(actual.getAttribute(VALUE), actual.getText()));
        }
    }
    private void addCities() {
        // https://www.selenium.dev/documentation/webdriver/elements/select_lists/
        System.out.println("Collection: cities");
        WebElement selectElement = driver.findElement(By.name("mycity"));
        Select selectObject = new Select(selectElement);
        List<WebElement> allAvailableOptions = selectObject.getOptions();

        for (int i = 1; i < allAvailableOptions.size(); i++){
            WebElement actual = allAvailableOptions.get(i);
            cities.add(new Cities(actual.getAttribute(VALUE), actual.getText()));
        }
    }
    private void addDistances() {
        // https://www.selenium.dev/documentation/webdriver/elements/select_lists/
        System.out.println("Collection: distances");
        WebElement selectElement = driver.findElement(By.name("myrad"));
        Select selectObject = new Select(selectElement);
        List<WebElement> allAvailableOptions = selectObject.getOptions();

        for (int i = 1; i < allAvailableOptions.size(); i++){
            WebElement actual = allAvailableOptions.get(i);
            distances.add(new Distances(actual.getAttribute(VALUE), actual.getText()));
        }
    }

}
