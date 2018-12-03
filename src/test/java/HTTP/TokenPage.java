package HTTP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TokenPage {

    //Третья страница, в которой находится список токенов
    WebDriver driver;

    public TokenPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTokenValue(){
        WebElement tokenValueElement = driver.findElement(By.xpath("//div[@class='token_container']/p[1]"));
        return tokenValueElement.getText();
    }
}
