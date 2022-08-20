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

    private final String queryUrl = "https://holtankoljak.hu/index.php?ua_map=1&uz_tip=%d&mycity=%d&myrad=%d#page_ad";
    private WebDriver driver;

    private List<FuelTypes> fuelTypes = new ArrayList<>();
    private List<Cities> cities = new ArrayList<>();
    private List<Distances> distances = new ArrayList<>();

    public FuelPrice() {
        driver = initDriver();
        setLists();
    }

    public void distancesList() {
        System.out.println(distances.toString());
    }
    public void quitDriver() {
        driver.quit();
    }
    private WebDriver initDriver() {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://holtankoljak.hu/";
        driver.get(baseUrl);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]"));
        submitButton.click();

        return driver;
    }

    private void setLists() {
        addDistances();

    }

    private void addFuelTypes() {
        // https://www.selenium.dev/documentation/webdriver/elements/select_lists/
        WebElement selectElement = driver.findElement(By.name("uz_tip"));
        Select selectObject = new Select(selectElement);
        List<WebElement> allAvailableOptions = selectObject.getOptions();

        for (int i = 1; i < allAvailableOptions.size(); i++){
            WebElement actual = allAvailableOptions.get(i);
            fuelTypes.add(new FuelTypes(actual.getAttribute("value"), actual.getText()));
        }
    }
    private void addCities() {
        // https://www.selenium.dev/documentation/webdriver/elements/select_lists/
        WebElement selectElement = driver.findElement(By.name("mycity"));
        Select selectObject = new Select(selectElement);
        List<WebElement> allAvailableOptions = selectObject.getOptions();

        for (int i = 1; i < allAvailableOptions.size(); i++){
            WebElement actual = allAvailableOptions.get(i);
            cities.add(new Cities(actual.getAttribute("value"), actual.getText()));
        }
    }
    private void addDistances() {
        // https://www.selenium.dev/documentation/webdriver/elements/select_lists/
        WebElement selectElement = driver.findElement(By.name("myrad"));
        Select selectObject = new Select(selectElement);
        List<WebElement> allAvailableOptions = selectObject.getOptions();

        for (int i = 1; i < allAvailableOptions.size(); i++){
            WebElement actual = allAvailableOptions.get(i);
            distances.add(new Distances(actual.getAttribute("value"), actual.getText()));
        }
    }

}
