package org.oleynik.training.selenium.steps;

import org.oleynik.training.selenium.pages.AdminLoginPage;
import org.oleynik.training.selenium.pages.AdminPage;
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

    public WebDriver driver;

    public GeneralSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Login into admin console.
     */
    public AdminPage adminLogin(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.open();
        adminLoginPage.getUsernameElement().sendKeys("admin");
        adminLoginPage.getPasswordElement().sendKeys("admin");
        adminLoginPage.getLoginElement().click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("box-apps-menu")));
        return new AdminPage(driver);
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
