package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OverviewTest extends BaseTest {

    @Test
    public void checkItemCostTest(){
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        assertEquals(overviewPage.getItemCost(), "Item total: $15.99",
                "Wrong cost information");
    }

    @Test
    public void checkTaxAmountTest(){
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        assertEquals(overviewPage.getTaxAmount(), "Tax: $1.28",
                "Wrong tax information");
    }

    @Test
    public void checkTotalPriceTest(){
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        assertEquals(overviewPage.getTotalPrice(), "Total: $17.27",
                "Wrong total price information");
    }

    @Test
    public void completeShoppingTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        overviewPage.confirmPurchaseGood();
        assertEquals(overviewPage.getcompleteMassage(), "Your order has been dispatched," +
                        " and will arrive just as fast as the pony can get there!",
                "Shopping do not finished successfully");
    }

    @Test
    public void cancelShoppingTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        overviewPage.cancelPurchaseGood();
        assertEquals(overviewPage.getProductsTittleText(), "PRODUCTS",
                "Wrong page opened");
    }

    @Test
    public void checkGoodsDescriptionTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        checkoutPage.openPage();
        checkoutPage.enterUserInformation("Jon", "Wick", "11111");
        checkoutPage.confirmUserInformation();
        overviewPage.returnToGoodsDescription();
        assertEquals(overviewPage.getGoodsNameText(), "Test.allTheThings() T-Shirt (Red)",
                "Wrong page opened");
    }
}
