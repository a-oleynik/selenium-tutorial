package org.oleynik.training.selenium.litecard.test;

import org.oleynik.training.selenium.BaseTest;
import org.oleynik.training.selenium.pages.CheckoutPage;
import org.oleynik.training.selenium.pages.ItemPage;
import org.oleynik.training.selenium.pages.MainPage;
import org.oleynik.training.selenium.steps.GeneralSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Task 13. Operations with items and the cart.
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
        ItemPage itemPage = new ItemPage(driver);
        for (int i = 1; i <= NUMBER_OF_CART_ITEMS; i++) {
            //Open the application
            generalSteps.openExternalLitecart();
            //Open the first product
            mainPage.getAllProducts().get(0).click();
            //Add the item to cart (choose optional size if exists)
            itemPage.selectFirstOptionsSizeIfExists();
            itemPage.getAddToCartElement().click();
            //Wait for the cart counter
            wait.until(textToBePresentInElement(mainPage.getCartQuantityElement(), String.valueOf(i)));
        }

        //Open the cart by Checkout link
        CheckoutPage checkoutPage = mainPage.openCheckout();
        int chosenItems = NUMBER_OF_CART_ITEMS;

        //Remove all chosen items from the cart
        while (checkoutPage.getRemoveElements().size() > 0) {
            checkoutPage.removeVisibleItem();
            --chosenItems;
            wait.until(numberOfElementsToBe(CheckoutPage.CART_ITEM_BY, chosenItems));
        }
    }
}
