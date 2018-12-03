import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class BasicPage {

    //Базовый класс, благодаря которому осуществляется связь между всеми другими классами
    public static WebDriver driver;

    public static void initizalization(){
        System.setProperty("webdriver.chrome.driver", "C:\\Repository\\Rep1\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://192.168.15.201/express_oui";
        driver.get(baseURL);
    }


    //Создание скрина
    public  void putScreen() {
        File screenShot = ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE); //Создание скрина. Изначально он хранится во временной папке где-то на диске C. Путь можно увидеть в дебагере объекта screenShot
        String path = "C:/Repository/Rep1/src/main/Pages/" + screenShot.getName(); //Путь, где будем хранить скрины

        try {
            FileUtils.copyFile(screenShot, new File(path)); //Тут мы копируем файл из временной директории в нашу
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при создании скрина " + e.toString());
        }
    }

    public  WebDriver getDriver(){
        return this.driver;
    }
}
