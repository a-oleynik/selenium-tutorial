package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.String.format;

/**
 * Task 8.
 */
public class StickersTest extends BaseTest {
    GeneralSteps generalSteps;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void checkStickers() {
        generalSteps.openExternalLitecart();
        List<WebElement> products = driver.findElements(By.cssSelector("li.product div.image-wrapper"));
        System.out.println(format("%s products found.", products.size()));
        products.forEach(product ->
                Assert.assertTrue(product.findElements(By.cssSelector(".sticker")).size() == 1));
        System.out.println("Every product has only one sticker.");
    }
}
