package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    String cartButton = ".shopping_cart_link";
    String productName = ".inventory_item_name";
    String productPrice = ".inventory_item_price";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.findElement(By.cssSelector(cartButton)).click();
    }

    public String getProductName() {
        return driver.findElement(By.cssSelector(productName)).getText();
    }

    public String getProductPrice() {
        return driver.findElement(By.cssSelector(productPrice)).getText();
    }
}
