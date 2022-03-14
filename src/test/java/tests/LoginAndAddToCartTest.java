package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginAndAddToCartTest extends BaseTest {

    @Test
    public void loginTest() {
        loginPage.openPage();
        loginPage.login(USER, PASSWORD);

        assertEquals(driver.findElement(By.cssSelector(".title")).getText(),
                "PRODUCTS", "Login failed");
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.openPage();
        loginPage.login("", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Username is required",
                "error messages is not correct");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginPage.openPage();
        loginPage.login(USER, "");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required",
                "error messages is not correct");
    }

    @Test
    public void userNameShouldBeCorrect() {
        loginPage.openPage();
        loginPage.login("qwerty", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Username and password " +
                        "do not match any user in this service",
                "error messages is not correct");
    }

    @Test
    public void passwordShouldBeCorrect() {
        loginPage.openPage();
        loginPage.login(USER, "qwerty");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password " +
                        "do not match any user in this service",
                "error messages is not correct");
    }
}
