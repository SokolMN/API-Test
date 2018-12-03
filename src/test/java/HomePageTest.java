import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends BasicPage{
    WebDriver driver;


    HomePageTest(WebDriver driver){
        this.driver = driver;
    }


    public void newAct(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.className("siebui-icon-atc_new_vizit_active")).click();
    }
}
