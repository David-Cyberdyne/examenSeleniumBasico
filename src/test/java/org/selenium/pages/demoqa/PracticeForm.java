package org.selenium.pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeForm {

    private final WebDriver driver;

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By male = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label");
    private final By female = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label");
    private final By other = By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label");
    private final By mobile = By.id("userNumber");
    private final By dateOfBirth = By.id("dateOfBirthInput");
    private final By subjects = By.id("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']");
    private final By sports = By.id("hobbies-checkbox-1");
    private final By reading = By.id("hobbies-checkbox-2");
    private final By music = By.id("hobbies-checkbox-3");
    private final By picture = By.id("");
    private final By currentAddress = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");

    public void waitForElement(By elementLocator, Integer seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(elementLocator);
        wait.until(ExpectedConditions.visibilityOf(element));
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
        WebElement element = null;
        switch (gender){
            case "male":
                element = driver.findElement(male);
                break;
            case "female":
                element = driver.findElement(female);
                break;
            default:
                element = driver.findElement(other);
        }

        if (!element.isSelected()) element.click();
    }

    public void typeMobile(String mobile){
        waitForElement(this.mobile, 15);
        driver.findElement(this.mobile).sendKeys(mobile);
    }

    public void typeDateOfBirth(String date) throws InterruptedException {
        waitForElement(dateOfBirth, 15);
        driver.findElement(dateOfBirth).clear();
        Thread.sleep(5000);
        driver.findElement(dateOfBirth).sendKeys(date);
        driver.findElement(dateOfBirth).sendKeys(Keys.ENTER);
    }
}
