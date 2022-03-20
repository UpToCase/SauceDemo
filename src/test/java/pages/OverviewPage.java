package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By CANCEL_BUTTON = By.id("cancel");
    public static final By TITLE = By.cssSelector(".title");
    public static final By COMPLETE_MASSAGE = By.cssSelector(".complete-text");
    String inventoryProductLink = ".inventory_item_name";
    String productName = "[class='inventory_details_name large_size']";
    String itemCost = ".summary_subtotal_label";
    String taxAmount = ".summary_tax_label";
    String totalPrice = ".summary_total_label";

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public void confirmPurchaseGood() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void cancelPurchaseGood() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void returnToGoodsDescription() {
        driver.findElement(By.cssSelector(inventoryProductLink)).click();
    }

    public String getProductsTittleText() {
        return driver.findElement(TITLE).getText();
    }

    public String getcompleteMassage() {
        return driver.findElement(COMPLETE_MASSAGE).getText();
    }

    public String getGoodsNameText() {
        return driver.findElement(By.cssSelector
                (productName)).getText();
    }

    public String getItemCost() {
        return driver.findElement(By.cssSelector(itemCost)).getText();
    }

    public String getTaxAmount() {
        return driver.findElement(By.cssSelector(taxAmount)).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(By.cssSelector(totalPrice)).getText();
    }
}
