package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactoryPattern extends BasePage {

    @FindBy(id="user-name")
    WebElement userInput;
    @FindBy(id="password")
    WebElement passwordInput;
    @FindBy(id="login-button")
    WebElement loginButton;
    @FindBy(css="[data-test=error]")
    WebElement errorMassages;
    String page = "https://www.saucedemo.com/";

    public LoginPageWithPageFactoryPattern(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(page);
        PageFactory.initElements(driver,this);
    }

    public void login(String user, String password) {
        openPage();
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getError() {
        return errorMassages.getText();
    }
}
