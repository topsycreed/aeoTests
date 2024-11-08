package ui.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UiSteps {
    WebDriver driver;

    public UiSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://www.ae.com/us/en/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ae.com/us/en/");
    }
}
