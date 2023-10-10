package org.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.selenium.pages.demoqa.PracticeForm;
import org.selenium.pages.estadio.Homepage;
import org.testng.annotations.Test;

public class MyFirstTestCase {

    @Test
    public void exercise1() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.estadiodeportivo.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void exercise2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.estadiodeportivo.com/");
        driver.manage().window().maximize();

        Homepage homepage = new Homepage(driver);
        homepage.acceptCookies();
        homepage.clickOnShield();
        homepage.printMainNews();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void exercise3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.estadiodeportivo.com/");
        driver.manage().window().maximize();

        Homepage homepage = new Homepage(driver);
        homepage.acceptCookies();
        homepage.clickOnShield();
        homepage.printMainNews();
        homepage.clickNew(0);
        driver.navigate().back();
        homepage.printNew(0);
        homepage.printLastNew();
        homepage.clickLastNew();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void exercise4() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        PracticeForm practiceForm = new PracticeForm(driver);
        practiceForm.typeFirstName("Nombre de prueba");
        practiceForm.typeLastName("Apellido de prueba");
        practiceForm.selectGender("other");
        practiceForm.typeMobile("123456789");
        practiceForm.typeDateOfBirth("14 Nov 2018");

        Thread.sleep(5000);
        driver.quit();
    }

}
