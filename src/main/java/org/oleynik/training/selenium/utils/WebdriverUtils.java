package org.oleynik.training.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {
    public static boolean isElementPresent (WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until((WebDriver d) -> d.findElement(locator));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }
}
