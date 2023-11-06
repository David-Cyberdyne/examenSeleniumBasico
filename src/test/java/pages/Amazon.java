package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.General;

import java.util.List;

public class Amazon {

    private final WebDriver driver;

    public Amazon(WebDriver driver) {
        this.driver = driver;
    }

    private final By acceptCookies = By.id("sp-cc-accept");
    private final By date = By.cssSelector("#mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE > span > span");
    private final By searchBox = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");
    private final By freeShipment = By.cssSelector("#p_n_free_shipping_eligible\\/20930980031 > span > a > div.a-checkbox.a-checkbox-fancy.s-navigation-checkbox.aok-float-left > label > i");
    private final By orderBy = By.id("s-result-sort-select");

    public void printNames(){
        By selector = By.cssSelector("h2 > a > span");
        List<WebElement> elementos = driver.findElements(selector);
        System.out.println("\nNombre de los " + elementos.size() + " productos");
        System.out.println("--------------------------------------------------------");

        for (WebElement elemento : elementos) {
            System.out.println("* " + elemento.getText());
            }
    }
    public void orderResults(String order) throws InterruptedException {
        WebElement element = General.waitForElement(driver, orderBy, 15);

        Select select = new Select(element);
        select.selectByValue(order);
        Thread.sleep(5000);
    }
    public void selectFreeShipment() throws InterruptedException {
        WebElement element = General.waitForElement(driver, freeShipment, 15);
        element.click();
        Thread.sleep(5000);
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

    public void getDate(){
        WebElement element = General.waitForElement(driver, date, 15);
        String textoDelElemento = element.getText();
        System.out.println("\nFecha de entrega: ");
        System.out.println(textoDelElemento);
    }

    public void getPrice(){

        By price = By.cssSelector("span.a-price-whole");
        By fraction = By.cssSelector("span.a-price-fraction");
        List<WebElement> prices = driver.findElements(price);
        List<WebElement> fractions = driver.findElements(fraction);

        if (!prices.isEmpty()) {
            String euros = prices.get(0).getText();
            String cents = fractions.get(0).getText();

            System.out.println("\nPrecio del artículo: " + euros + "," + cents + "€");
        } else {
            System.out.println("No se encontraron elementos");
        }
    }
}
