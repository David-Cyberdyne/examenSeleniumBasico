package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.General;
public class Confirmation {

    private final WebDriver driver;

    public Confirmation(WebDriver driver) {
        this.driver = driver;
    }

    private final By facility = By.id("facility");
    private final By chkHospitalReadmission = By.id("hospital_readmission");
    private final By healthCareProgram = By.id("program");
    private final By visitDate = By.id("visit_date");
    private final By comment = By.id("comment");
    private final By menu = By.id("menu-toggle");
    private final By home = By.cssSelector("#sidebar-wrapper > ul > li:nth-child(3) > a");

    public void clickMenu(){
        WebElement element = General.waitForElement(driver, menu, 15);;
        element.click();
    }

    public void clickHome(){
        WebElement element = General.waitForElement(driver, home, 15);;
        element.click();
    }

    public void checkFacility(String value){
        WebElement element = General.waitForElement(driver, facility, 15);
        Assert.assertEquals(value, element.getText());
    }
    public void checkApply(String value){
        WebElement element = General.waitForElement(driver, chkHospitalReadmission, 15);
        Assert.assertEquals(value, element.getText());
    }
    public void checkProgram(String value){
        WebElement element = General.waitForElement(driver, healthCareProgram, 15);
        Assert.assertEquals(value, element.getText());
    }
    public void checkVisitDate(String value){
        WebElement element = General.waitForElement(driver, visitDate, 15);
        Assert.assertEquals(value, element.getText());
    }
    public void checkComment(String value){
        WebElement element = General.waitForElement(driver, comment, 15);
        Assert.assertEquals(value, element.getText());
    }
}
