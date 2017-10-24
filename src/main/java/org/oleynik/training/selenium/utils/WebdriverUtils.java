package org.oleynik.training.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WebdriverUtils {
    public static boolean isElementPresent(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until((WebDriver d) -> d.findElement(locator));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public static ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return input -> {
            Set<String> handles = input.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }
}
