package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public static final By FIRSTNAME = By.id("first-name");
    public static final By LASTNAME = By.id("last-name");
    public static final By POSTCODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By CANCEL_BUTTON = By.id("cancel");
    public static final By TITLE = By.cssSelector(".title");
    public static final By ERROR_MESSAGES = By.cssSelector("[data-test='error']");
    public static final By CHECKOUT_BUTTON = By.id("checkout");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void enterUserInformation(String firstName, String lastName, String postcode) {
        driver.findElement(FIRSTNAME).sendKeys(firstName);
        driver.findElement(LASTNAME).sendKeys(lastName);
        driver.findElement(POSTCODE).sendKeys(postcode);
    }

    public void confirmUserInformation() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void cancelCheckoutPage() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getTextFromErrorButton() {
        return driver.findElement(ERROR_MESSAGES).getText();
    }

    public String getPageTitle() {
        return driver.findElement(TITLE).getText();
    }
}
