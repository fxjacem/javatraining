package fuelprice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class FuelPriceTest {

    public WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        // WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void eightComponents() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        /*WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);
        */

//        WebDriverWait select = new WebDriverWait(driver, Duration.ofMillis(10000));
//        select.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));

        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select selectObject = new Select(selectElement);
        List<WebElement> allAvailableOptions = selectObject.getOptions();
        System.out.println(allAvailableOptions);
    }

}