package org.oleynik.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {
    private WebDriver driver;
    public static final String LOCAL_LITECART_ADMIN = "http://localhost:8080/litecard/admin/";
    public static final String EXTERNAL_LITECART_ADMIN = "http://litecart.stqa.ru/admin/";

    public  AdminLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdminLoginPage open(){
        driver.get(LOCAL_LITECART_ADMIN);
        return this;
    }

    public AdminLoginPage openExternal(){
        driver.get(EXTERNAL_LITECART_ADMIN);
        return this;
    }

    public WebElement getUsernameElement(){
        return driver.findElement(By.name("username"));
    }

    public WebElement getPasswordElement(){
        return driver.findElement(By.name("password"));
    }

    public WebElement getLoginElement(){
        return driver.findElement(By.name("login"));
    }
}
