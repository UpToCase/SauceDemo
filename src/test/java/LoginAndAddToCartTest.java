import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginAndAddToCartTest extends BaseTest {

    @Test
    public void loginTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertEquals(driver.findElement(By.cssSelector(".title")).getText(),
                "PRODUCTS", "Login failed");
    }
    @Test
    public void addToCurtTest() {
        loginTest();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText(),
                "Sauce Labs Backpack", "Have been chosen another good");
        assertEquals(driver.findElement(By.cssSelector(".inventory_item_price")).getText(),
                "$29.99", "Wrong good's price displayed");
    }
}
