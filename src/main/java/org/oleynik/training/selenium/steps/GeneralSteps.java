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

    public WebDriver driver;

    public GeneralSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Login into admin console.
     */
    public void adminLogin(){
        driver.navigate().to("http://localhost:8080/litecard/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("box-apps-menu")));
    }

    public List<WebElement> getAdminMenuList(){
        return driver.findElements(By.xpath(ADMIN_MENU_ITEM_XPATH_LOCATOR));
    }

    public List<WebElement> getAdminSubMenuList(){
        return driver.findElements(By.cssSelector(ADMIN_SUB_MENU_ITEM_CSS_LOCATOR));
    }
}
