package org.oleynik.training.selenium.litecart.test;

import com.google.common.collect.Comparators;
import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.format;

/**
 * Task 9.
 */
public class CountriesAndZonesSortingTest extends BaseTest {
    GeneralSteps generalSteps;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void checkSortingOfCountriesAndZones() {
        generalSteps.adminLogin();
        generalSteps.openCountries();
        System.out.println("Opening Countries");
        //Check countries
        List<WebElement> countries = driver.findElements(By.xpath("//*[contains(@class, row)]/td[5]/a"));
        List<String> countryLabels = new ArrayList<>();
        List<String> countriesWithZones = new ArrayList<>();
        countries.forEach(country -> {
            String countryName = country.getAttribute("textContent");
            countryLabels.add(countryName);
            if (!driver.findElement(By.xpath(format("//a[.=\"%s\"]/../following-sibling::*", countryName))).getText().equals("0")) {
                countriesWithZones.add(countryName);
            }
        });
        System.out.println(format("Found %s countries: \n %s", countryLabels.size(), countryLabels));
        Assert.assertTrue(Comparators.isInOrder(countryLabels, Comparator.comparing(String::toString)),
                "Countries are not sorted alphabetically.");
        System.out.println("Countries are sorted alphabetically.");
        System.out.println(format("Found %s countries with a few zones : \n %s", countriesWithZones.size(), countriesWithZones));
        //Check countries with few zones
        countriesWithZones.forEach(country -> {
            System.out.println(format("Checking zones for %s", country));
            generalSteps.openCountries();
            driver.findElement(By.xpath(format("//a[.=\"%s\"]", country))).click();
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(.,'Edit Country')]")));
            List<WebElement> zones = driver.findElements(By.xpath("id(\"table-zones\")//tr[not(@class='header')]/td[3]/input[not(@data-type)]"));
            List<String> zoneLabels = new ArrayList<>();
            zones.forEach(zone -> zoneLabels.add(zone.getAttribute("value")));
            Assert.assertTrue(Comparators.isInOrder(zoneLabels, Comparator.comparing(String::toString)),
                    format("Zones are not sorted alphabetically for %s.", country));
            System.out.println(format("Zones are sorted alphabetically for %s.", country));
        });

        //Check zones
        generalSteps.openGeoZones();
        System.out.println("Opening Geo Zones");
        List<WebElement> zonedCountries = driver.findElements(By.xpath("//form//td[3]/a"));
        List<String> zonedCountryLabels = new ArrayList<>();
        zonedCountries.forEach(country -> zonedCountryLabels.add(country.getAttribute("textContent")));
        System.out.println(format("Found %s countries: \n %s", zonedCountryLabels.size(), zonedCountryLabels));
        zonedCountryLabels.forEach(country -> {
            System.out.println(format("Checking zones for %s", country));
            generalSteps.openGeoZones();
            driver.findElement(By.xpath(format("//form//td[3]/a[.=\"%s\"]", country))).click();
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(.,'Edit Geo Zone')]")));
            List<WebElement> zones = driver.findElements(By.xpath("id(\"table-zones\")//tr[not(@class='header')]/td[3]/select"));
            List<String> zoneLabels = new ArrayList<>();
            zones.forEach(zone -> zoneLabels.add(zone.getAttribute("textContent")));
            Assert.assertTrue(Comparators.isInOrder(zoneLabels, Comparator.comparing(String::toString)),
                    format("Zones are not sorted alphabetically for %s.", country));
            System.out.println(format("Zones are sorted alphabetically for %s.", country));
        });
    }
}
