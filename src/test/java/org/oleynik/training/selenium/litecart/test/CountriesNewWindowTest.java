package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CountriesNewWindowTest extends BaseTest {
    private static GeneralSteps generalSteps;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void countriesOpenNewWindow() {
        generalSteps.adminLogin();
        generalSteps.openCountries();
        generalSteps.openAddNewCountryDialogue();
        generalSteps.openAndClosePopupsFromNewCountryDialogue();
    }
}
