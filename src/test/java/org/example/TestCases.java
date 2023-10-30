package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.General;

import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.Properties;

public class TestCases {
    WebDriver driver = null;

    @BeforeTest
    public void initializeBrowser() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "chromedriver");
        driver = new ChromeDriver();
        driver.get(General.getUrl());
        driver.manage().window().maximize();
    }

    @Test
    public void exercise1() throws InterruptedException {

        String article = "Compresor eléctrico";

        GoogleHome googleHome = new GoogleHome(driver);
        googleHome.clickDenyCookies();
        googleHome.search(article);
        Thread.sleep(5000);
        GoogleResults googleResults = new GoogleResults(driver);
        googleResults.clickResult();

        Thread.sleep(5000);
    }

    @Test
    public void example(){
        System.out.println("Funciona");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
