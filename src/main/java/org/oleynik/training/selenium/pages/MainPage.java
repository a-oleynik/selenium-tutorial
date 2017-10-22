package org.oleynik.training.selenium.pages;

import org.oleynik.training.selenium.utils.CSSValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public final static String FIRST_CAMPAIGN_ITEM_TITLE = "//*[@id='box-campaigns']//li/a[1]";
    public final static String CAMPAIGN_PRICE = "//strong[contains(@class,'campaign-price')]";
    public final static String REGULAR_PRICE = "//s[contains(@class,'regular-price')]";


    public WebElement getFirstCampaignItemElement() {
        return driver.findElement(By.xpath(FIRST_CAMPAIGN_ITEM_TITLE));
    }

    public String getFirstCampaignItemTitle() {
        return getFirstCampaignItemElement().getAttribute("title");
    }

    public WebElement getFirstCampaignItemCampaignPriceElement() {
        return driver.findElement(By.xpath(CAMPAIGN_PRICE));
    }

    public String getFirstCampaignItemCampaignPrice() {
        return getFirstCampaignItemCampaignPriceElement().getText();
    }

    public String getFirstCampaignItemCampaignPriceColor() {
        return getFirstCampaignItemCampaignPriceElement().getCssValue(CSSValues.COLOR);
    }

    public String getFirstCampaignItemCampaignPriceFontWeight() {
        return getFirstCampaignItemCampaignPriceElement().getCssValue(CSSValues.FONT_WEIGHT);
    }

    public String getFirstCampaignItemCampaignPriceFontSize() {
        return getFirstCampaignItemCampaignPriceElement().getCssValue(CSSValues.FONT_SIZE);
    }

    public WebElement getFirstCampaignItemRegularPriceElement() {
        return driver.findElement(By.xpath(REGULAR_PRICE));
    }

    public String getFirstCampaignItemRegularPrice() {
        return getFirstCampaignItemRegularPriceElement().getText();
    }

    public String getFirstCampaignItemRegularPriceColor() {
        return getFirstCampaignItemRegularPriceElement().getCssValue(CSSValues.COLOR);
    }

    public String getFirstCampaignItemRegularPriceTextDecoration() {
        return getFirstCampaignItemRegularPriceElement().getCssValue(CSSValues.TEXT_DECORATION);
    }

    public String getFirstCampaignItemRegularPriceFontSize() {
        return getFirstCampaignItemRegularPriceElement().getCssValue(CSSValues.FONT_SIZE);
    }

}
