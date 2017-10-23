package org.oleynik.training.selenium.pages;

import org.oleynik.training.selenium.utils.CSSValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ItemPage {

    private WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public final static String CAMPAIGN_PRICE = "//strong[contains(@class,'campaign-price')]";
    public final static String REGULAR_PRICE = "//s[contains(@class,'regular-price')]";
    public final static By OPTIONS_SIZE_BY = By.name("options[Size]");


    public String getItemTitle() {
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public WebElement getItemCampaignPriceElement() {
        return driver.findElement(By.xpath(CAMPAIGN_PRICE));
    }

    public String getItemCampaignPrice() {
        return getItemCampaignPriceElement().getText();
    }

    public String getItemCampaignPriceColor() {
        return getItemCampaignPriceElement().getCssValue(CSSValues.COLOR);
    }

    public String getItemCampaignPriceFontWeight() {
        return getItemCampaignPriceElement().getCssValue(CSSValues.FONT_WEIGHT);
    }

    public String getItemCampaignPriceFontSize() {
        return getItemCampaignPriceElement().getCssValue(CSSValues.FONT_SIZE);
    }

    public WebElement getItemRegularPriceElement() {
        return driver.findElement(By.xpath(REGULAR_PRICE));
    }

    public String getItemRegularPrice() {
        return getItemRegularPriceElement().getText();
    }

    public String getItemRegularPriceColor() {
        return getItemRegularPriceElement().getCssValue(CSSValues.COLOR);
    }

    public String getItemRegularPriceTextDecoration() {
        return getItemRegularPriceElement().getCssValue(CSSValues.TEXT_DECORATION);
    }

    public String getItemRegularPriceFontSize() {
        return getItemRegularPriceElement().getCssValue(CSSValues.FONT_SIZE);
    }

    public WebElement getAddToCartElement() {
        return driver.findElement(By.name("add_cart_product"));
    }

    public WebElement getOptionSizeElement() {
        return driver.findElement(OPTIONS_SIZE_BY);
    }

    public void selectFirstOptionSize(){
        new Select(getOptionSizeElement()).selectByIndex(1);
    }

    public void selectFirstOptionsSizeIfExists(){
        if(driver.findElements(OPTIONS_SIZE_BY).size() > 0){
            selectFirstOptionSize();
        }
    }
}
