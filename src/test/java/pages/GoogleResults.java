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

    public void clickResult(){
        List<WebElement> enlaces = driver.findElements(By.tagName("a"));

        // Filtra los enlaces que contienen "amazon" en la URL
        for (WebElement enlace : enlaces) {
            String url = enlace.getAttribute("href");
            //System.out.println("URL " + url);
            if (url != null && url.contains("amazon")) {
                System.out.println("Hay enlace a Amazon");
                System.out.println(url);
                driver.get(url);
                //enlace.click();
                break; // Hacer clic en el primer enlace y salir del bucle
            }
        }
    }

}
