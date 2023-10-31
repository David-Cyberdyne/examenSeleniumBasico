package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class General {
    //Esperar un tiempo determinado a que aparezca un elemento y se devuelve el elemento.
    public static WebElement waitForElement(WebDriver driver, By elementLocator, Integer seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(elementLocator);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        return element;
    }

    public static WebElement waitForElementClickable(WebDriver driver, By elementLocator, Integer seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(elementLocator);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return element;
    }

    public static void expectPageToLoadCompletely(WebDriver driver){
        // Espera a que la página se cargue por completo
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
    }

    //Leer el fichero de configuración y devolver las propiedades
    public static Properties readConfigFile() throws IOException {
        // Ruta al archivo de configuración
        String configFile = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.properties";

        // Crear un objeto Properties para cargar el archivo de configuración
        Properties properties = new Properties();

        // Cargar el archivo de configuración
        FileInputStream inputStream = new FileInputStream(configFile);
        properties.load(inputStream);
        inputStream.close();

        // Obtener valores de configuración
        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");

        // Usar los valores de configuración en tu prueba de Selenium
        System.out.println("URL: " + url);
        System.out.println("Navegador: " + browser);

        return properties;
    }

    //Devolver uno de los valores del fichero de configuración: url.
    public static String getUrl() throws IOException {
        Properties properties = General.readConfigFile();
        String url = properties.getProperty("url");
        return url;
    }
}
