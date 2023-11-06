package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.General;

public class GoogleHome {

    private final WebDriver driver;

    public GoogleHome(WebDriver driver) {
        this.driver = driver;
    }

    private final By denyCookies = By.id("W0wltc");
    private final By searchBox = By.name("q");

    public void clickDenyCookies(){
        WebElement element = General.waitForElement(driver, denyCookies, 15);
        element.click();
    }

    public void search(String text) throws InterruptedException {
        WebElement element = General.waitForElement(driver, searchBox, 15);
        element.sendKeys(text);
        element.submit();
        Thread.sleep(2000);
    }
}
