package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void productShouldBeAddedInToCurtTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCurt("Test.allTheThings() T-Shirt (Red)");
        cartPage.openCart();
        assertEquals(cartPage.getProductName(),
                "Test.allTheThings() T-Shirt (Red)", "Invalid product name displayed");
        assertEquals(cartPage.getProductPrice(),
                "$15.99", "Invalid product price displayed");
    }
}
