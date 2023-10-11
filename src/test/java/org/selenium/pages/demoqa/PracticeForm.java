package org.selenium.pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PracticeForm {

    private WebDriver driver;

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    private By firstName = By.id("firstName");
    private By firstNameXPath = By.xpath("//*[@id=\"firstName\"]");
    private By lastName = By.id("lastName");
    private By lastNameXPath = By.xpath("//*[@id=\"lastName\"]");
    private final By male = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label");
    private final By maleXPath = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By female = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label");
    private final By femaleXPath = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private final By other = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label");
    private final By otherXPath = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label");
    private By mobile = By.id("userNumber");
    private By mobileXPath = By.xpath("//*[@id=\"userNumber\"]");
    private By dateOfBirth = By.id("dateOfBirthInput");
    private By dateOfBirthXPath = By.xpath("//*[@id=\"dateOfBirthInput\"]");
    private By subjects = By.id("subjectsInput");
    private By subjectsXPath = By.xpath("//*[@id=\"subjectsInput\"]");
    private By sports = By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label");
    private By sportsXPath = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label");
    private By reading = By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label");
    private By readingXPath = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label");
    private By music = By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label");
    private By musicXPath = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label");
    private By picture = By.id("uploadPicture");
    private By pictureXPath = By.xpath("//*[@id=\"uploadPicture\"]");
    private By currentAddress = By.id("currentAddress");
    private By currentAddressXPath = By.xpath("//*[@id=\"currentAddress\"]");
    private By state = By.id("react-select-3-input");
    private By stateXPath = By.xpath("//*[@id=\"react-select-3-input\"]");
    private By city = By.id("react-select-4-input");
    private By cityXPath = By.xpath("//*[@id=\"react-select-4-input\"]");

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

    public void typeFirstNameXPath(String text){
        waitForElement(firstNameXPath, 15);
        driver.findElement(firstNameXPath).sendKeys(text);
    }

    public void typeLastName(String text){
        waitForElement(lastName, 15);
        driver.findElement(lastName).sendKeys(text);
    }

    public void typeLastNameXPath(String text){
        waitForElement(lastNameXPath, 15);
        driver.findElement(lastNameXPath).sendKeys(text);
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

    public void selectGenderXPath(String gender){
        switch (gender) {
            case "male":
                driver.findElement(maleXPath).click();
                break;
            case "female":
                driver.findElement(femaleXPath).click();
                break;
            default:
                driver.findElement(otherXPath).click();
        }
    }

    public void typeMobile(String mobile){
        waitForElement(this.mobile, 15);
        driver.findElement(this.mobile).sendKeys(mobile);
    }
    public void typeMobileXPath(String mobile){
        waitForElement(mobileXPath, 15);
        driver.findElement(mobileXPath).sendKeys(mobile);
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
    public void typeDateOfBirthXPath(String date) throws InterruptedException {
        WebElement element = driver.findElement(dateOfBirthXPath);
        waitForElement(dateOfBirthXPath, 15);
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
    public void typeSubjectsXPath(String text){
        WebElement element = driver.findElement(subjectsXPath);
        waitForElement(subjectsXPath, 15);
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
    public void selectHobbysXPath(String hobby){
        switch (hobby) {
            case "sports":
                driver.findElement(sportsXPath).click();
                break;
            case "reading":
                driver.findElement(readingXPath).click();
                break;
            case "music":
                driver.findElement(musicXPath).click();
                break;
            default:
                break;
        }
    }

    public void typeAddress(String text){
        waitForElement(currentAddress, 15);
        driver.findElement(currentAddress).sendKeys(text);
    }
    public void typeAddressXPath(String text){
        waitForElement(currentAddressXPath, 15);
        driver.findElement(currentAddressXPath).sendKeys(text);
    }

    public void typeState(String text){
        WebElement element = driver.findElement(state);
        waitForElement(state, 15);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
    public void typeStateXPath(String text){
        WebElement element = driver.findElement(stateXPath);
        waitForElement(stateXPath, 15);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void typeCity(String text){
        WebElement element = driver.findElement(city);
        waitForElement(city, 15);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void typeCityXPath(String text){
        WebElement element = driver.findElement(cityXPath);
        waitForElement(cityXPath, 15);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void uploadFile(String text){
        File file = new File(text);
        String path = file.getAbsolutePath();
        driver.findElement(picture).sendKeys(path);
    }

    public void uploadFileXPath(String text){
        File file = new File(text);
        String path = file.getAbsolutePath();
        driver.findElement(pictureXPath).sendKeys(path);
    }
}
