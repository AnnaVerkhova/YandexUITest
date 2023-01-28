package driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utills.WebDriverListener;

import java.time.Duration;

public class DriverSingleton {

    static Logger log = Logger.getRootLogger();
    private static EventFiringWebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/win/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver());
            driver.register(new WebDriverListener());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
        log.info("Get driver");
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            log.info("Close driver");
            driver = null;
        }
    }
}
