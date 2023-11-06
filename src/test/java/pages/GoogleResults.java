package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResults {

    private final WebDriver driver;

    public GoogleResults(WebDriver driver) {
        this.driver = driver;
    }

    public void clickResult(){
        List<WebElement> enlaces = driver.findElements(By.tagName("a"));

        // Filtra los enlaces que contienen "amazon" en la URL
        for (WebElement enlace : enlaces) {
            String url = enlace.getAttribute("href");
            if (url != null && url.contains("amazon")) {
                driver.get(url);
                break;
            }
        }
    }

}
