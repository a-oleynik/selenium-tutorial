package org.oleynik.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTaxIdElement(){
        return driver.findElement(By.name("tax_id"));
    }

    public WebElement getCompanyElement(){
        return driver.findElement(By.name("company"));
    }

    public WebElement getFirstNameElement(){
        return driver.findElement(By.name("firstname"));
    }

    public WebElement getLastNameElement(){
        return driver.findElement(By.name("lastname"));
    }

    public WebElement getAddress1Element(){
        return driver.findElement(By.name("address1"));
    }

    public WebElement getAddress2Element(){
        return driver.findElement(By.name("address2"));
    }

    public WebElement getPostcodeElement(){
        return driver.findElement(By.name("postcode"));
    }

    public WebElement getCityElement(){
        return driver.findElement(By.name("city"));
    }

    public void selectCountry(String country){
        driver.findElement(By.className("select2-selection__rendered")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys(country + Keys.ENTER);
    }

    public WebElement getZoneElement() {
        return driver.findElement(By.xpath("//select[@name='zone_code']"));
    }

    public void selectZone(String zone){
        Select select = new Select(getZoneElement());
        select.selectByVisibleText(zone);
    }

    public WebElement getEmailElement() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPhoneElement() {
        return driver.findElement(By.name("phone"));
    }

    public WebElement getPasswordElement() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getConfirmedPasswordElement() {
        return driver.findElement(By.name("confirmed_password"));
    }

    public WebElement getCreateAccountElement() {
        return driver.findElement(By.name("create_account"));
    }

}
