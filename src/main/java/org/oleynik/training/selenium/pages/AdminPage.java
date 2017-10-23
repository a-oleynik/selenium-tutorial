package org.oleynik.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
    private WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCatalogElement() {
        return driver.findElement(By.xpath("id('box-apps-menu')//li/a/span[.='Catalog']"));
    }

    public WebElement getAddNewProductElement() {
        return driver.findElement(By.xpath("id('content')//a[contains(., 'Add New Product')]"));
    }

    public WebElement getEnabledElement() {
        return driver.findElement(By.xpath("id('tab-general')//label[contains(text(),'Enabled')]"));
    }

    public WebElement getNameElement() {
        return driver.findElement(By.name("name[en]"));
    }

    public WebElement getCodeElement() {
        return driver.findElement(By.cssSelector("[name=code]"));
    }

    public WebElement getRubberDucksCategoryElement() {
        return driver.findElement(By.cssSelector("[data-name='Rubber Ducks']"));
    }

    public WebElement getMaleProductGroupElement() {
        return driver.findElement(By.cssSelector("[value='1-2']"));
    }

    public WebElement getQuantityElement() {
        return driver.findElement(By.cssSelector("[name=quantity]"));
    }

    public WebElement getUploadImagesElement() {
        return driver.findElement(By.cssSelector("[name='new_images[]']"));
    }

    public WebElement getDateValidFromElement() {
        return driver.findElement(By.cssSelector("[name='date_valid_from']"));
    }

    public WebElement getDateValidToElement() {
        return driver.findElement(By.cssSelector("[name='date_valid_to']"));
    }


    public WebElement getTabInformationElement() {
        return driver.findElement(By.cssSelector("[href='#tab-information']"));
    }

    public WebElement getManufacturerElement() {
        return driver.findElement(By.name("manufacturer_id"));
    }

    public void selectManufacturerByValue(String value){
        Select manufacturerSelect = new Select(getManufacturerElement());
        manufacturerSelect.selectByValue(value);
    }

    public WebElement getKeywordsElement() {
        return driver.findElement(By.name("keywords"));
    }

    public WebElement getShortDescriptionElement() {
        return driver.findElement(By.name("short_description[en]"));
    }

    public WebElement getHeadTitleElement() {
        return driver.findElement(By.name("head_title[en]"));
    }

    public WebElement getMetaDescriptionElement() {
        return driver.findElement(By.name("meta_description[en]"));
    }

    public WebElement getPricesTabElement() {
        return driver.findElement(By.cssSelector("[href='#tab-prices']"));
    }

    public WebElement getPurchasePriceElement() {
        return driver.findElement(By.cssSelector("[name='purchase_price']"));
    }

    public WebElement getPurchasePriceCurrencyCodeElement(){
        return driver.findElement(By.cssSelector("[name='purchase_price_currency_code']"));
    }

    public void selectPurchasePriceCurrencyCode(String currencyCode){
        new Select(getPurchasePriceCurrencyCodeElement()).selectByValue(currencyCode);
    }

    public WebElement getSaveNewItemElement(){
        return driver.findElement(By.cssSelector("[name='save']"));
    }
}
