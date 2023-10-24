package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Confirmation;
import pages.Homepage;
import pages.LoginPage;
import pages.MakeAppointment;
import utils.General;

import java.io.IOException;
import java.lang.System;
import java.util.Properties;

public class TestCases {
    WebDriver driver = null;

    @BeforeTest
    public void initializeBrowser() throws IOException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\dpanalca\\IntellijIDEA-Projects\\CursoSeleniumUdemy\\Test Basico\\src\\test\\resources\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver.get(General.getUrl());
        driver.manage().window().maximize();
    }

    @Test
    public void exercise1() throws InterruptedException {

        String facility = General.getFacility();
        String program = "None";
        String comment = "Comment";
        String date = "10/11/2023";
        String apply = "Yes";

        Homepage homepage = new Homepage(driver);
        homepage.clickOnMakeAppointmentButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName();
        loginPage.typePassword();
        loginPage.login();

        MakeAppointment makeAppointment = new MakeAppointment(driver);
        makeAppointment.selectFacility(facility);
        makeAppointment.checkHospitalReadmission();
        makeAppointment.selectProgram(program);
        makeAppointment.selectVisitDate(date);
        makeAppointment.typeComment(comment);
        makeAppointment.clickBookButton();

        Confirmation confirmation = new Confirmation(driver);
        confirmation.checkFacility(facility);
        confirmation.checkApply(apply);
        confirmation.checkVisitDate(date);
        confirmation.checkProgram(program);
        confirmation.checkComment(comment);

        confirmation.clickMenu();
        confirmation.clickHome();

        //Thread.sleep(5000);
    }

    @Test
    public void example(){
        String facility = General.getFacility();
        System.out.println(facility);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
