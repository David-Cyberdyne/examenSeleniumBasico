package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.General;

import java.io.File;
import java.io.IOException;
import java.lang.System;

public class TestCases {
    WebDriver driver = null;

    @BeforeTest
    public void initializeBrowser() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(General.getUrl());
        driver.manage().window().maximize();
    }

    @Test
    public void exercise1() throws InterruptedException {

        String article = "Compresor eléctrico";
        String order = "price-asc-rank";

        /* Paso 1: acceder a Google. El navegador de abre en el paso inicial marcado como @BeforeTest, donde
        se abre Chrome y se navega a https://www.google.es que es una dirección almacenada en
        el fichero de configuración. Después de eso se rechazan las cookies para poder seguir navegando.*/
        GoogleHome googleHome = new GoogleHome(driver);
        googleHome.clickDenyCookies();

        /*Paso 2: hacemos la búsqueda del producto.
        El producto buscado está almacenado en la variable article de este test*/
        googleHome.search(article);

        /*Paso 3: en la página de resultados buscamos el enlace que contenga la palabra Amazon y accedemos a él*/
        GoogleResults googleResults = new GoogleResults(driver);
        googleResults.clickResult();

        /*Paso 4: en la página de Amazon, aceptamos las cookies e imprimimos por consola
         el precio y la fecha de entrega del producto*/
        Amazon amazon = new Amazon(driver);
        amazon.clickAcceptCookies();
        amazon.getPrice2();
        amazon.getDate();

        /*Paso 5: usamos el buscador para encontrar el listado de productos*/
        amazon.typeSearchTerm(article);
        amazon.clickOnSearchButton();

        /*Paso 6: en mi caso no me aparece el filtro de entregas Prime así que escojo el filtro entrega gratis*/
        amazon.selectFreeShipment();

        /*Paso 7: ordenamos los resultados de menor a mayor precio*/
        amazon.orderResults(order);

        /*Paso 8: imprimimos por consola todos los nombres de los artículos de la búsqueda, descartando el resto*/
        amazon.printNames();

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
