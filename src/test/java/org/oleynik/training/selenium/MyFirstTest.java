package org.oleynik.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends BaseTest{
    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        //((HasCapabilities)driver).getCapabilities();
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleContains("webdriver"));
    }
}
