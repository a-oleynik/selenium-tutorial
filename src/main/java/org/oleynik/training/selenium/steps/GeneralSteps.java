package org.oleynik.training.selenium.steps;

import org.oleynik.training.selenium.pages.*;
import org.oleynik.training.selenium.utils.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;


/**
 * A class with reusable test steps.
 */
public class GeneralSteps {
    public static final String ADMIN_MENU_ITEM_XPATH_LOCATOR = "//ul[@id='box-apps-menu']/li";
    public static final String ADMIN_SUB_MENU_ITEM_CSS_LOCATOR = "ul#box-apps-menu li.selected ul.docs li";
    public static final String EXTERNAL_LITE_CART_SITE = "http://litecart.stqa.ru/index.php/en/";

    public WebDriver driver;
    private MainPage mainPage;
    private ItemPage itemPage;
    private CheckoutPage checkoutPage;
    private AdminPage adminPage;
    private WebDriverWait wait;

    public GeneralSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        itemPage = new ItemPage(driver);
        checkoutPage = new CheckoutPage(driver);
        adminPage = new AdminPage(driver);
        wait = (new WebDriverWait(driver, 10));
    }

    /**
     * Login into admin console.
     */
    public AdminPage adminLogin() {
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.open();
        adminLoginPage.getUsernameElement().sendKeys("admin");
        adminLoginPage.getPasswordElement().sendKeys("admin");
        adminLoginPage.getLoginElement().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("box-apps-menu")));
        return new AdminPage(driver);
    }

    public List<WebElement> getAdminMenuList() {
        return driver.findElements(By.xpath(ADMIN_MENU_ITEM_XPATH_LOCATOR));
    }

    public List<WebElement> getAdminSubMenuList() {
        return driver.findElements(By.cssSelector(ADMIN_SUB_MENU_ITEM_CSS_LOCATOR));
    }

    /**
     * Navigate to http://litecart.stqa.ru/index.php/en/
     */
    public void openExternalLitecart() {
        driver.get(EXTERNAL_LITE_CART_SITE);
    }

    /**
     * Navigate to local litecart
     */
    public void openLocalLitecart() {
        mainPage.openMainPage();
    }

    public void waitPageTitle(String title) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(format("//h1[contains(.,\"%s\")]", title))));
    }

    public void openCountries() {
        adminPage.getCountriesElement().click();
        waitPageTitle("Countries");
    }

    public void openAddNewCountryDialogue() {
        adminPage.getNewCountryElement().click();
        waitPageTitle("Add New Country");
    }

    public void openAndClosePopupsFromNewCountryDialogue() {
        List<WebElement> popupLinks = adminPage.getAllCountryPopupFields();
        String countryEditWindow = driver.getWindowHandle();
        Set<String> openWindows = driver.getWindowHandles();
        popupLinks.forEach(link -> {
            link.click();
            String newWindow = wait.until(WebdriverUtils.anyWindowOtherThan(openWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(countryEditWindow);
        });
    }

    public void openGeoZones() {
        driver.findElement(By.xpath("//li/a/*[.='Geo Zones']")).click();
        waitPageTitle("Geo Zones");
    }

    public void addFirstItemToCart() {
        //Open the application
        openLocalLitecart();
        //Open the first product
        mainPage.getAllProducts().get(0).click();
        //Add the item to cart (choose optional size if exists)
        itemPage.selectFirstOptionsSizeIfExists();
        itemPage.getAddToCartElement().click();
    }

    public void addFewFirstItemsToCart(int numberOfItems) {
        for (int i = 1; i <= numberOfItems; i++) {
            addFirstItemToCart();
            //Wait for the cart counter
            wait.until(textToBePresentInElement(mainPage.getCartQuantityElement(), String.valueOf(i)));
        }
    }

    public CheckoutPage openCheckoutPage() {
        //Open the cart by Checkout link
        return mainPage.openCheckout();
    }

    public void removeItemsFromCart(int numberOfItems) {
        //Remove all chosen items from the cart
        while (checkoutPage.getRemoveElements().size() > 0) {
            checkoutPage.removeVisibleItem();
            --numberOfItems;
            wait.until(numberOfElementsToBe(CheckoutPage.CART_ITEM_BY, numberOfItems));
        }
    }
}
