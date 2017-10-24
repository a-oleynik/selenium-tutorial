package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.pages.CreateAccountPage;
import org.oleynik.training.selenium.pages.MainPage;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.oleynik.training.selenium.utils.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Task 11.
 */
public class UserRegistrationTest extends BaseTest {
    private static GeneralSteps generalSteps;
    private static final String EMAIL = Utils.generateRandomEmail();
    private static final String PASSWORD = "12345678";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void checkUserRegistration() {
        MainPage mainPage = new MainPage(driver);
        CreateAccountPage createAccountPage = mainPage.openMainPage()
                .clickCreateNewCustomer();
        createAccountPage.getTaxIdElement().sendKeys("12452556");
        createAccountPage.getCompanyElement().sendKeys("AT&T");
        createAccountPage.getFirstNameElement().sendKeys("Vasiliy");
        createAccountPage.getLastNameElement().sendKeys("Pupkin");
        createAccountPage.getAddress1Element().sendKeys("Peach street");
        createAccountPage.getAddress2Element().sendKeys("Apricot street");
        createAccountPage.getPostcodeElement().sendKeys("12345");
        createAccountPage.getCityElement().sendKeys("New York");
        createAccountPage.selectCountry("United States");
        createAccountPage.selectZone("New York");
        System.out.println("User email: " + EMAIL);
        System.out.println("User password: " + PASSWORD);
        createAccountPage.getEmailElement().sendKeys(EMAIL);
        createAccountPage.getPhoneElement().sendKeys("2128506");
        createAccountPage.getPasswordElement().sendKeys(PASSWORD);
        createAccountPage.getConfirmedPasswordElement().sendKeys("12345678");
        createAccountPage.getCreateAccountElement().click();
        mainPage.getLogoutElement().click();
        mainPage.getEmailElement().sendKeys(EMAIL);
        mainPage.getPasswordElement().sendKeys(PASSWORD);
        mainPage.getLoginElement().click();
        mainPage.getLogoutElement().click();
    }
}
