package org.oleynik.training.selenium.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * A class with reusable test steps.
 */
public class GeneralSteps {
    public static final String ADMIN_MENU_ITEM_XPATH_LOCATOR = "//ul[@id='box-apps-menu']/li";
    public static final String ADMIN_SUB_MENU_ITEM_CSS_LOCATOR = "ul#box-apps-menu li.selected ul.docs li";
    public static final String EXTERNAL_LITE_CART_SITE = "http://litecart.stqa.ru/index.php/en/";
    public static final String LOCAL_LITECART_ADMIN = "http://localhost:8080/litecard/admin/";
    public static final String EXTERNAL_LITECART_ADMIN = "http://litecart.stqa.ru/admin/";

    public WebDriver driver;

    public GeneralSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Login into admin console.
     */
    public void adminLogin(String adminUrl){
        driver.navigate().to(adminUrl);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("box-apps-menu")));
    }

    /**
     * Login into admin console (local litecart site).
     */
    public void adminLogin(){
        adminLogin(LOCAL_LITECART_ADMIN);
    }

    /**
     * Login into admin console (external litecart site).
     */
    public void adminLoginToExternalLitecart(){
        adminLogin(EXTERNAL_LITECART_ADMIN);
    }

    public List<WebElement> getAdminMenuList(){
        return driver.findElements(By.xpath(ADMIN_MENU_ITEM_XPATH_LOCATOR));
    }

    public List<WebElement> getAdminSubMenuList(){
        return driver.findElements(By.cssSelector(ADMIN_SUB_MENU_ITEM_CSS_LOCATOR));
    }

    /**
     * Navigate to http://litecart.stqa.ru/index.php/en/
     */
    public void openExternalLitecart(){
        driver.get(EXTERNAL_LITE_CART_SITE);
    }

    public void openCountries(){
        driver.findElement(By.xpath("//li/a/*[.='Countries']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(.,'Countries')]")));
    }

    public void openGeoZones(){
        driver.findElement(By.xpath("//li/a/*[.='Geo Zones']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(.,'Geo Zones')]")));
    }
}
