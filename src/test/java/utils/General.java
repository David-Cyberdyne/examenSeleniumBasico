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
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    //Leer el fichero de configuración y devolver las propiedades
    public static Properties readConfigFile() throws IOException {
        // Ruta al archivo de configuración
        String configFile = "src\\test\\resources\\config.properties";

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

    //Leer el fichero de datos JSON usando Jackson
    public static JsonNode readJSONData(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el JSON desde un archivo
            JsonNode jsonNode = objectMapper.readTree(new File("src\\test\\resources\\userData.json")); // Reemplaza con la ubicación correcta

            // Acceder a los datos del JSON según sea necesario
            //String nombre = jsonNode.get("facility").asText();
            //String correoElectronico = jsonNode.get("program").asText();

            return jsonNode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFacility(){
        JsonNode jsonNode = readJSONData();
        return jsonNode.get("facility").asText();
    }
}
