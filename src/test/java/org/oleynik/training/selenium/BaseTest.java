package org.oleynik.training.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        // Disable message about application testing mode
        chromeOptions.addArguments("disable-infobars");
        // Disabling save password prompt
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(chromeCapabilities);

        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability(FirefoxDriver.MARIONETTE, true);
        //driver = new FirefoxDriver(caps);

        //caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        //driver = new InternetExplorerDriver(caps);
        tlDriver.set(driver);
        //System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null; }));
    }

    @AfterMethod
    public void stop() {
        //driver.quit();
        //driver = null;
    }
}
