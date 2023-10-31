package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.General;

public class GoogleHome {

    private WebDriver driver;

    public GoogleHome(WebDriver driver) {
        this.driver = driver;
    }

    private final By denyCookies = By.id("W0wltc");
    private final By searchBox = By.id("APjFqb");
    private final By searchButton = By.cssSelector("input[type='submit'][value='Buscar con Google']");

    public void clickDenyCookies(){
        WebElement element = General.waitForElement(driver, denyCookies, 15);
        element.click();
    }

    public void search(String text) throws InterruptedException {
        WebElement element = General.waitForElement(driver, searchBox, 15);
        element.sendKeys(text);
        Thread.sleep(5000);
    }

    public void clickOnSearchButton() {
        WebElement element = General.waitForElement(driver, searchButton, 15);
        element.click();
    }
}
