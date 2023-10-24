package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.General;

public class MakeAppointment {

    private final WebDriver driver;

    public MakeAppointment(WebDriver driver) {
        this.driver = driver;
    }

    private final By facility = By.id("combo_facility");
    private final By chkHospitalReadmission = By.id("chk_hospotal_readmission");
    private final By visitDate = By.id("txt_visit_date");
    private final By comment = By.id("txt_comment");
    private final By bookAppointmentButton = By.id("btn-book-appointment");

    public void selectFacility(String selection){
        WebElement element = General.waitForElement(driver, facility, 15);
        Select dropdown = new Select(element);
        dropdown.selectByValue(selection);
    }

    public void typeComment(String text){
        WebElement element = General.waitForElement(driver, comment, 15);
        element.sendKeys(text);
    }

    public void checkHospitalReadmission(){
        WebElement element = General.waitForElement(driver, chkHospitalReadmission, 15);;
        if (!element.isSelected()){
            element.click();
        }
    }
    public void selectProgram(String program){
        WebElement element = driver.findElement(By.xpath("//*[@value='" + program +"']"));
        element.click();
    }

    public void selectVisitDate(String date){
        WebElement element = General.waitForElement(driver, visitDate, 15);
        element.sendKeys(date);
    }

    public void clickBookButton(){
        WebElement element = General.waitForElement(driver, bookAppointmentButton, 15);
        element.click();
    }
}
