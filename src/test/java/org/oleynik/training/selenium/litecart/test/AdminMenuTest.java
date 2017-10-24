package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.oleynik.training.selenium.utils.WebdriverUtils.*;
import static org.testng.Assert.assertTrue;

/**
 * Task 7.
 */
public class AdminMenuTest extends BaseTest {
    GeneralSteps generalSteps;
    public static final String ADMIN_HEADER_CSS_LOCATOR = "h1";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void openAdminSimpleTest() {
        generalSteps.adminLogin();
        //Getting menu items
        int menuListSize = generalSteps.getAdminMenuList().size();

        for (int itemIndex = 0; itemIndex < menuListSize; itemIndex++) {
            WebElement menuItem = generalSteps.getAdminMenuList().get(itemIndex);
            String menuName = menuItem.getText();
            System.out.println("Opening menu item " + menuName + ".");
            menuItem.click();

            //Getting sub menu items
            int subListSize = generalSteps.getAdminSubMenuList().size();
            if (subListSize > 0) {
                for (int subItemIndex = 0; subItemIndex < subListSize; subItemIndex++) {
                    WebElement subMenuItem = generalSteps.getAdminSubMenuList().get(subItemIndex);
                    String subMenuName = subMenuItem.getText();
                    System.out.println("Opening submenu item " + subMenuName + ".");
                    subMenuItem.click();
                    assertTrue(isElementPresent(driver, By.cssSelector(ADMIN_HEADER_CSS_LOCATOR)), "h1 header not found.");
                    System.out.println("h1 header is found. It equals " + driver.findElement(By.cssSelector(ADMIN_HEADER_CSS_LOCATOR)).getText());
                }
            } else {
                System.out.println("The item " + menuName + " doesn't have subitems.");
            }
        }


    }
}

