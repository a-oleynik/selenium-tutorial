package org.oleynik.training.selenium.litecart.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.pages.MainPage;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

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
        for (int i = 1; i <= NUMBER_OF_CART_ITEMS; i++) {
            generalSteps.addFirstItemToCart();
            //Wait for the cart counter
            wait.until(textToBePresentInElement(mainPage.getCartQuantityElement(), String.valueOf(i)));
        }

        //Open the cart by Checkout link
        generalSteps.openCheckoutPage();

        //Remove all chosen items from the cart
        generalSteps.removeItemsFromCart(NUMBER_OF_CART_ITEMS);
    }
}
