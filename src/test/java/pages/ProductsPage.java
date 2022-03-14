package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    String addToCartButton = "//*[contains(text(),'%s')]//" +
            "ancestor::*[@class='inventory_item']//descendant::button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCurt(String productName) {
        driver.findElement(By.xpath(String.format(addToCartButton, productName))).click();
    }
}
