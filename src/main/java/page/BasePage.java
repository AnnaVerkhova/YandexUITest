package page;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {

    private WebDriver driver = DriverSingleton.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private Logger log;
    private ArrayList<String> tabs;
    private boolean goToHandle;

    private void sleep(Integer sec) {
        long seconds = sec;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    protected WebElement lookElement(By locator) {
        return driver.findElement(locator);
    }

    public void lookForElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void open(String pageURL) {
        driver.get(pageURL);
    }

    public void goToHandle() {
        for (String goToHandle : driver.getWindowHandles()) {
            driver.switchTo().window(goToHandle);
        }
    }

    public void switchToTheTab(int tab) {
        sleep(2500);
        if (tabs == null) {
            tabs = new ArrayList<>(driver.getWindowHandles());
        }
        driver.switchTo().window(tabs.get(tab));
    }
}
