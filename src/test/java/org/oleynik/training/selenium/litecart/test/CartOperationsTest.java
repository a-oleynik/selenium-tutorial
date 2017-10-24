package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.pages.MainPage;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Task 13 / 19. Operations with items and the cart.
 */
public class CartOperationsTest extends BaseTest {
    private static GeneralSteps generalSteps;
    private static final int NUMBER_OF_CART_ITEMS = 3;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        generalSteps = new GeneralSteps(driver);
    }

    @Test
    public void checkCartScenario() {
        MainPage mainPage = new MainPage(driver);
        //Add 3 items to cart
        generalSteps.addFewFirstItemsToCart(NUMBER_OF_CART_ITEMS);
        //Open the cart by Checkout link
        generalSteps.openCheckoutPage();
        //Remove all chosen items from the cart
        generalSteps.removeItemsFromCart(NUMBER_OF_CART_ITEMS);
    }
}
