package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.General;
public class Homepage {

    private final WebDriver driver;
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
    private final By makeAppointmentButton = By.id("btn-make-appointment");

    public void clickOnMakeAppointmentButton(){
        WebElement element = General.waitForElement(driver, makeAppointmentButton, 15);
        element.click();
    }

}
