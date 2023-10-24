package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.General;
public class LoginPage {

    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By user = By.cssSelector("#login > div > div > div.col-sm-offset-3.col-sm-6 > form > div.alert.alert-info > div:nth-child(1) > div > div > input");
    private final By pass = By.cssSelector("#login > div > div > div.col-sm-offset-3.col-sm-6 > form > div.alert.alert-info > div:nth-child(2) > div > div > input");
    private final By username = By.id("txt-username");
    private final By password = By.id("txt-password");
    private final By loginButton = By.id("btn-login");

    public String getUser(){
        WebElement element = General.waitForElement(driver, user, 15);
        return element.getAttribute("value");
    }

    public String getPass(){
        WebElement element = General.waitForElement(driver, pass, 15);
        return element.getAttribute("value");
    }

    public void typeUserName(){
        WebElement element = General.waitForElement(driver, username, 15);
        element.sendKeys(getUser());
    }

    public void typePassword(){
        WebElement element = General.waitForElement(driver, password, 15);
        element.sendKeys(getPass());
    }

    public void login(){
        WebElement element = General.waitForElement(driver, loginButton, 15);
        element.click();
    }

}
