package org.selenium.pages.estadio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Homepage {

    private WebDriver driver;

    public Homepage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private By acceptCookiesButton = By.id("acceptAllMain");
    private By betisBadge = By.cssSelector("body > div.c-cuerpo.con-barra-seo.sin-destacadas > div:nth-child(4) > span > span > div > ul > li:nth-child(11) > a");
    private By mainNews = By.cssSelector("article > span > h2 > a");

    //Methods to interact with the page
    public void acceptCookies(){
        driver.findElement(acceptCookiesButton).click();
    }

    public void clickOnShield(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = driver.findElement(betisBadge);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void printMainNews(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = driver.findElement(mainNews);
        wait.until(ExpectedConditions.visibilityOf(element));

        List<WebElement> newsTitles = driver.findElements(mainNews);

        for(WebElement title: newsTitles){
            System.out.println(title.getText());
        }
    }

    public void printNew(Integer newNumber){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = driver.findElement(mainNews);
        wait.until(ExpectedConditions.visibilityOf(element));

        List<WebElement> newsTitles = driver.findElements(mainNews);
        System.out.println("La noticia número "+ newNumber +" es: \n");
        System.out.println(newsTitles.get(newNumber).getText() + "\n");
    }

    public void printLastNew(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = driver.findElement(mainNews);
        wait.until(ExpectedConditions.visibilityOf(element));

        List<WebElement> newsTitles = driver.findElements(mainNews);
        System.out.println("La última noticia es: \n");
        System.out.println(newsTitles.get(newsTitles.size() -1).getText() + "\n");
    }

    public void clickNew(Integer newNumber){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = driver.findElement(mainNews);
        wait.until(ExpectedConditions.visibilityOf(element));

        List<WebElement> newsTitles = driver.findElements(mainNews);
        newsTitles.get(newNumber).click();
    }

    public void clickLastNew(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = driver.findElement(mainNews);
        wait.until(ExpectedConditions.visibilityOf(element));

        List<WebElement> newsTitles = driver.findElements(mainNews);
        newsTitles.get(newsTitles.size() -1).click();
    }

}
