package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {

    @Test
    public void login() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void createNewLocators() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("login_logo"));
        driver.findElement(By.tagName("input"));

        login();
        driver.findElement(By.linkText("Twitter")).click();
        driver.findElement(By.partialLinkText("Tw"));
    }

    @Test
    public void createXpathLocators() {

        driver.get("https://www.saucedemo.com/");
        login();
        driver.findElement(By.xpath("//*[@class='peek']"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']"));
        driver.findElements(By.xpath("//*[contains(@class,'inventory')]"));
        driver.findElements(By.xpath("//*[contains(text(),'Sauce Labs')]"));
        driver.findElement(By.xpath("//*[@class='inventory_list']//ancestor::body"));
        driver.findElement(By.xpath("//*[@class='inventory_list']//ancestor-or-self::body"));
        driver.findElements(By.xpath("//*[@class='primary_header']/descendant::*"));
        driver.findElement(By.xpath("//*[@class='primary_header']/following::footer"));
        driver.findElement(By.xpath("//*[@alt='Sauce Labs Onesie']/parent::*"));
        driver.findElements(By.xpath("//*[@target='_blank']/preceding::*"));
        driver.findElements(By.xpath("//*[@data-test='remove-sauce-labs-backpack' and @name='remove-sauce-labs-backpack']"));
    }

    @Test
    public void createCCSLocators() {
        driver.get("https://www.saucedemo.com/");
        login();
        driver.findElement(By.cssSelector(".header_label"));
        driver.findElements(By.cssSelector(".header_label.header_secondary_container"));
        driver.findElements(By.cssSelector(".inventory_container .inventory_item"));
        driver.findElement(By.cssSelector("#menu_button_container"));
        driver.findElements(By.cssSelector("img"));
        driver.findElements(By.cssSelector("img.inventory_item_img"));
        driver.findElement(By.cssSelector("[class='pricebar']"));
        driver.findElements(By.cssSelector("[alt~='Labs']"));
        driver.findElements(By.cssSelector("[name|='cart']"));
        driver.findElements(By.cssSelector("[name^='add']"));
        driver.findElements(By.cssSelector("[class$='price']"));
        driver.findElement(By.cssSelector("[data-test*='t-shirt-(red)']"));
    }
}
