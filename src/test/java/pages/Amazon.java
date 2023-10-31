package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.General;

import java.util.List;

public class Amazon {

    private WebDriver driver;

    public Amazon(WebDriver driver) {
        this.driver = driver;
    }

    private final By acceptCookies = By.id("sp-cc-accept");
    private final By price = By.cssSelector("#corePrice_feature_div > div > div > span.a-price.aok-align-center > span.a-offscreen");
    private final By date = By.cssSelector("#mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE > span > span");
    private final By searchBox = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");
    private final By freeShipment = By.cssSelector("#p_n_free_shipping_eligible\\/20930980031 > span > a > div.a-checkbox.a-checkbox-fancy.s-navigation-checkbox.aok-float-left > label > i");
    private final By orderBy = By.id("s-result-sort-select");

    public void printNames(){
        By selector = By.cssSelector("h2 > a > span");
        List<WebElement> elementos = driver.findElements(selector);
        System.out.println("Cantidad de productos" + elementos.size());

        for (WebElement elemento : elementos) {
            System.out.println(elemento.getText());
            }
    }
    public void orderResults(String order) throws InterruptedException {
        WebElement element = General.waitForElement(driver, orderBy, 15);

        // Crea un objeto Select
        Select select = new Select(element);

        // Selecciona una opción por valor (cambia "valor_a_seleccionar" por el valor deseado)
        select.selectByValue(order);
        Thread.sleep(5000);
    }
    public void selectFreeShipment() throws InterruptedException {
        WebElement element = General.waitForElement(driver, freeShipment, 15);
        element.click();
        Thread.sleep(15000);
    }

    public void clickOnSearchButton(){
        WebElement element = General.waitForElement(driver, searchButton, 15);
        element.click();
    }

    public void typeSearchTerm(String text){
        WebElement element = General.waitForElement(driver, searchBox, 15);
        element.sendKeys(text);
    }

    public void clickAcceptCookies(){
        WebElement element = General.waitForElement(driver, acceptCookies, 15);
        element.click();
    }

    public void getPrice(){
        WebElement element = General.waitForElement(driver, price, 15);
        String textoDelElemento = element.getText();
        System.out.println(textoDelElemento);
        System.out.println(element);
    }

    public void getDate(){
        WebElement element = General.waitForElement(driver, date, 15);
        String textoDelElemento = element.getText();
        System.out.println("Fecha de entrega: \n");
        System.out.println(textoDelElemento);
    }

    public void getPrice2(){
        // Localiza todos los elementos por su clase
        By selector = By.cssSelector("span.a-offscreen");
        List<WebElement> elementos = driver.findElements(selector);

        // Verifica si se encontraron elementos
        if (!elementos.isEmpty()) {
            // Obtiene el texto del primer elemento
            String textoDelPrimerElemento = elementos.get(0).getText();

            // Imprime el texto en la consola
            System.out.println("Texto del primer elemento: " + textoDelPrimerElemento);
        } else {
            System.out.println("No se encontraron elementos con la clase 'a-offscreen'.");
        }
    }
}
