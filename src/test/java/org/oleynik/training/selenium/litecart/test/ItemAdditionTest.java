package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.pages.AdminPage;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.UUID;

/**
 * Task 12.
 */
public class ItemAdditionTest extends BaseTest {
    private static GeneralSteps generalSteps;
    private String newDuckPic = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "new_duck.png";
    private static final String NEW_ITEM_NAME = "New rubber DUCK " + UUID.randomUUID();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void checkItemAddition() {
        AdminPage adminPage = generalSteps.adminLogin();
        adminPage.getCatalogElement().click();
        adminPage.getAddNewProductElement().click();
        adminPage.getEnabledElement().click();
        adminPage.getNameElement().sendKeys(NEW_ITEM_NAME);
        adminPage.getCodeElement().sendKeys("123456");
        adminPage.getRubberDucksCategoryElement().click();
        adminPage.getMaleProductGroupElement().click();
        adminPage.getQuantityElement().clear();
        adminPage.getQuantityElement().sendKeys("10");
        adminPage.getUploadImagesElement().sendKeys(newDuckPic);
        adminPage.getDateValidFromElement().sendKeys("01012017");
        adminPage.getDateValidToElement().sendKeys("01012018");
        adminPage.getTabInformationElement().click();
        adminPage.selectManufacturerByValue("1");
        adminPage.getKeywordsElement().sendKeys("duck, rubber");
        adminPage.getShortDescriptionElement().sendKeys("Super puper rubber duck.");
        //Workaround to enter description
        adminPage.getShortDescriptionElement().sendKeys(Keys.TAB, "Description of the duck");
        adminPage.getHeadTitleElement().sendKeys("New duck");
        adminPage.getMetaDescriptionElement().sendKeys("Duck is everywhere!");
        adminPage.getPricesTabElement().click();
        adminPage.getPurchasePriceElement().clear();
        adminPage.getPurchasePriceElement().sendKeys("15");
        adminPage.selectPurchasePriceCurrencyCode("USD");
        adminPage.getSaveNewItemElement().click();
        //Check if the item is added.
        driver.findElement(By.linkText(NEW_ITEM_NAME));
        System.out.println("The item is added.");
    }
}
