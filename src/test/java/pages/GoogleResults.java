package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.General;

import java.util.List;

public class GoogleResults {

    private WebDriver driver;

    public GoogleResults(WebDriver driver) {
        this.driver = driver;
    }

    private final By denyCookies = By.id("W0wltc");
    private final By searchBox = By.id("APjFqb");
    private final By searchButton = By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b");

    public void clickResult(){
        List<WebElement> enlaces = driver.findElements(By.tagName("a"));

        // Filtra los enlaces que contienen "amazon" en la URL
        for (WebElement enlace : enlaces) {
            String url = enlace.getAttribute("data-pcu");
            System.out.println("URL " + url);
            if (url != null && url.contains("amazon")) {
                System.out.println("Hay enlace a Amazon");
                System.out.println(url);
                enlace.click();
                break; // Hacer clic en el primer enlace y salir del bucle
            }
        }
    }

    public void search(String text){
        WebElement element = General.waitForElement(driver, searchBox, 15);
        WebElement element2 = General.waitForElement(driver, searchButton, 15);
        element.sendKeys(text);
        element2.click();
    }
}
