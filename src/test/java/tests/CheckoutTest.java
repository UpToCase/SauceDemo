package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        assertEquals(checkoutPage.getPageTitle(),
                "CHECKOUT: OVERVIEW", "Wrong page opened");
    }

    @Test
    public void inCheckoutShouldFirstNameBeEnteredTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        assertEquals(checkoutPage.getTextFromErrorButton(),
                "Error: First Name is required", "Wrong error massage");
    }

    @Test
    public void inCheckoutShouldLastNameBeEnteredTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "", "11111");
        checkoutPage.confirmUserInformation();
        assertEquals(checkoutPage.getTextFromErrorButton(),
                "Error: Last Name is required", "Wrong error massage");
    }

    @Test
    public void checkoutShouldPostalCodeBeEnteredTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "");
        checkoutPage.confirmUserInformation();
        assertEquals(checkoutPage.getTextFromErrorButton(),
                "Error: Postal Code is required", "Wrong error massage");
    }

    @Test
    public void checkoutShouldBeCanceledInCartPageTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.cancelCheckoutPage();
        assertEquals(checkoutPage.getPageTitle(),
                "YOUR CART", "Checkout canceled wrong page");
    }
}
