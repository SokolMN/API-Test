import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest2 extends BasicPage {

    /*

    WebDriver driver;

    LoginPageTest2(WebDriver driver) {
        this.driver = driver;
        //  this.driver = super.getDriver();
    }



    public WebDriver login(String loginName, String loginPass){


        this.driver.findElement(By.id("s_swepi_1")).sendKeys(loginName);
        this.driver.findElement(By.id("s_swepi_2")).sendKeys(loginPass);
        this.driver.findElement(By.id("s_swepi_22")).submit();
        return (driver);
    }*/
    public WebDriver login(String loginName, String loginPass){


        driver.findElement(By.id("s_swepi_1")).sendKeys(loginName);
        driver.findElement(By.id("s_swepi_2")).sendKeys(loginPass);
        driver.findElement(By.id("s_swepi_22")).submit();
        return (driver);
    }

}
