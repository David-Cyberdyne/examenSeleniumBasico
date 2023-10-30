package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.General;

public class GoogleHome {

    private WebDriver driver;

    public GoogleHome(WebDriver driver) {
        this.driver = driver;
    }

    private final By denyCookies = By.id("W0wltc");
    private final By searchBox = By.id("APjFqb");
    private final By searchButton = By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b");

    public void clickDenyCookies(){
        WebElement element = General.waitForElement(driver, denyCookies, 15);
        element.click();
    }

    public void search(String text){
        WebElement element = General.waitForElement(driver, searchBox, 15);
        WebElement element2 = General.waitForElement(driver, searchButton, 15);
        element.sendKeys(text);
        element2.click();
    }
}
