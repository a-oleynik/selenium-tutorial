package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.pages.AdminPage;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Task 17.
 */
public class LogEntryTest extends BaseTest {
    private static GeneralSteps generalSteps;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void checkWebdriverLogEntryDuringItemAdminPageOpening() {
        AdminPage adminPage = generalSteps.adminLogin();
        adminPage.getCatalogElement().click();
        adminPage.getFirstItemCategoryFromCatalogElement().click();
        int numberOfItems = adminPage.getAllItemsFromCatalog().size();
        for (int i = 0; i < numberOfItems; i++) {
            adminPage.getAllItemsFromCatalog().get(i).click();
            Assert.assertEquals(driver.manage().logs().get("browser").getAll().size(), 0,
                    "The webdriver browser log has messages: " + driver.manage().logs().get("browser").getAll());
            adminPage.getCatalogElement().click();
            adminPage.getFirstItemCategoryFromCatalogElement().click();
        }
    }
}
