package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.model.Item;
import org.oleynik.training.selenium.pages.ItemPage;
import org.oleynik.training.selenium.pages.MainPage;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.oleynik.training.selenium.utils.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Task 10.
 */
public class ItemPageContentTest extends BaseTest {
    private static GeneralSteps generalSteps;
    private static final String STRIKEOUT = "line-through";
    private static final String BOLD = "700";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void compareItemDetailsOnTheItemPageAndMainPage() {
        SoftAssert softAssert = new SoftAssert();
        //Open the main page and read properties
        generalSteps.openExternalLitecart();
        MainPage mainPage = new MainPage(driver);
        Item mainPageItem = new Item(mainPage.getFirstCampaignItemTitle());
        mainPageItem.setCampaignPrice(mainPage.getFirstCampaignItemCampaignPrice());
        mainPageItem.setRegularPrice(mainPage.getFirstCampaignItemRegularPrice());
        //Check regular price (strikeout, gray)
        softAssert.assertTrue(mainPage.getFirstCampaignItemRegularPriceTextDecoration().contains(STRIKEOUT),
                "The regular price on the Main page is not strikeout.");
        softAssert.assertTrue(Utils.getRGBAFromCSSColor(mainPage.getFirstCampaignItemRegularPriceColor()).isGray(),
                "The regular price on the Main page is not gray.");
        //Check sale price (bold, red)
        softAssert.assertTrue(mainPage.getFirstCampaignItemCampaignPriceFontWeight().contains(BOLD),
                "The campaign price on the Main page is not bold.");
        softAssert.assertTrue(Utils.getRGBAFromCSSColor(mainPage.getFirstCampaignItemCampaignPriceColor()).isRed(),
                "The campaign price on the Main page is not red.");
        //Check sale price font size bigger than the usual one
        double regularPriceFontSize = Utils.getFontSizeValue(mainPage.getFirstCampaignItemRegularPriceFontSize());
        double campaignPriceFontSize = Utils.getFontSizeValue(mainPage.getFirstCampaignItemCampaignPriceFontSize());
        softAssert.assertTrue(regularPriceFontSize < campaignPriceFontSize,
                "The font size on the Main page for the regular price is bigger the one for the campaign price.");

        //Open the item page and read properties
        mainPage.getFirstCampaignItemElement().click();
        ItemPage itemPage = new ItemPage(driver);
        Item itemPageItem = new Item(itemPage.getItemTitle());
        itemPageItem.setCampaignPrice(itemPage.getItemCampaignPrice());
        itemPageItem.setRegularPrice(itemPage.getItemRegularPrice());
        //Check regular price (strikeout, gray)
        softAssert.assertTrue(itemPage.getItemRegularPriceTextDecoration().contains(STRIKEOUT),
                "The regular price on the Item page is not strikeout.");
        softAssert.assertTrue(Utils.getRGBAFromCSSColor(itemPage.getItemRegularPriceColor()).isGray(),
                "The regular price on the Item page is not gray.");
        //Check sale price (bold, red)
        softAssert.assertTrue(itemPage.getItemCampaignPriceFontWeight().contains(BOLD),
                "The campaign price on the Item page is not bold.");
        softAssert.assertTrue(Utils.getRGBAFromCSSColor(itemPage.getItemCampaignPriceColor()).isRed(),
                "The campaign price on the Item page is not red.");
        //Check sale price font size bigger than the usual one
        regularPriceFontSize = Utils.getFontSizeValue(itemPage.getItemRegularPriceFontSize());
        campaignPriceFontSize = Utils.getFontSizeValue(itemPage.getItemCampaignPriceFontSize());
        softAssert.assertTrue(regularPriceFontSize < campaignPriceFontSize,
                "The font size on the Item page for the regular price is bigger the one for the campaign price.");
        //Compare properties on the main page and the item one
        softAssert.assertEquals(mainPageItem, itemPageItem, "Item has different details on the Item Page and the Main Page.");
        softAssert.assertAll();
    }
}
