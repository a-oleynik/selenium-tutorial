package org.oleynik.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class MyFirstTest extends BaseTest{
    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        //((HasCapabilities)driver).getCapabilities();
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait.until(titleContains("webdriver"));
    }
}
