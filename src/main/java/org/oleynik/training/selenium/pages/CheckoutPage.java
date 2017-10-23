package org.oleynik.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    public static final By CART_ITEM_BY = By.xpath("//ul[@class='items']//li");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getRemoveElements(){
        return driver.findElements(By.name("remove_cart_item"));
    }

    public void removeVisibleItem(){
        WebElement remove = getRemoveElements().get(0);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(remove));
        remove.click();
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(By.xpath("//ul[@class='items']//li"));
    }
}
