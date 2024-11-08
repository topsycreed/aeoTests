package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.steps.UiSteps;

public class SmokeTests {
    WebDriver driver;
    UiSteps uiSteps;

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        uiSteps = new UiSteps(driver);
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }

    @Test
    void firstUiTest() {
        driver.get("https://www.ae.com/us/en/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ae.com/us/en/");
    }

    @Test
    void acceptOneTrustTest() throws InterruptedException {
        //предусловия
        uiSteps.openHomePage();
        //действия
        Thread.sleep(5000);
        WebElement acceptAll = driver.findElement(By.xpath("//button[@id = 'onetrust-accept-btn-handler']"));
        acceptAll.click();
        //проверки
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ae.com/us/en/");
    }
}
