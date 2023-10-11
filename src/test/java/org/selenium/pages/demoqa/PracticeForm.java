package org.selenium.pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeForm {

    private WebDriver driver;

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private final By male = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label");
    private final By female = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label");
    private final By other = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label");
    private By mobile = By.id("userNumber");
    private By dateOfBirth = By.id("dateOfBirthInput");
    private By subjects = By.id("subjectsInput");
    private By sports = By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label");
    private By reading = By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label");
    private By music = By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label");
    private By picture = By.id("");
    private By currentAddress = By.id("currentAddress");
    private By state = By.id("react-select-3-input");
    private By city = By.id("react-select-4-input");

    public WebElement waitForElement(By elementLocator, Integer seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(elementLocator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public void typeFirstName(String text){
        waitForElement(firstName, 15);
        driver.findElement(firstName).sendKeys(text);
    }

    public void typeLastName(String text){
        waitForElement(lastName, 15);
        driver.findElement(lastName).sendKeys(text);
    }

    public void selectGender(String gender){
        switch (gender) {
            case "male":
                driver.findElement(male).click();
                break;
            case "female":
                driver.findElement(female).click();
                break;
            default:
                driver.findElement(other).click();
        }
    }

    public void typeMobile(String mobile){
        waitForElement(this.mobile, 15);
        driver.findElement(this.mobile).sendKeys(mobile);
    }

    public void typeDateOfBirth(String date) throws InterruptedException {
        WebElement element = driver.findElement(dateOfBirth);
        waitForElement(dateOfBirth, 15);
        element.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
    }

    public void typeSubjects(String text){
        WebElement element = driver.findElement(subjects);
        waitForElement(subjects, 15);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void selectHobbys(String hobby){
        switch (hobby) {
            case "sports":
                driver.findElement(sports).click();
                break;
            case "reading":
                driver.findElement(reading).click();
                break;
            case "music":
                driver.findElement(music).click();
                break;
            default:
                break;
        }
    }

    public void typeAddress(String text){
        waitForElement(currentAddress, 15);
        driver.findElement(currentAddress).sendKeys(text);
    }

    public void typeState(String text){
        WebElement element = driver.findElement(state);
        waitForElement(state, 15);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void typeCity(String text){
        WebElement element = driver.findElement(city);
        waitForElement(city, 15);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
}
