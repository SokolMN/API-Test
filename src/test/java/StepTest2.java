import bsh.util.BshCanvas;
import org.apache.commons.io.FileUtils;
import org.apache.tika.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import static org.testng.Assert.assertEquals;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Listeners(SetUpListenersClass.class)
public class StepTest2 extends BasicPage {

    //WebDriver driver;



    @BeforeClass
    public void getStartPage(){

        System.out.println("Hello");
        initizalization();

    }
 /*Тут реализован второй способ получения скрина. Но он мне не нравится. Аннотация AfterMethod будет запускать мой метод
 каждый раз, и проверять не случилась ли ошибка
    @AfterMethod
    public  void checkStatus(ITestResult result){
        if(result.isSuccess()) {
            return;
        }else{
            File screenShot = ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
            String path = "C:/Repository/Rep1/src/main/Pages/" + screenShot.getName();

            try {
                FileUtils.copyFile(screenShot, new File(path));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ошибка при создании скрина " + e.toString());
            }
        }

    }*/

    @Test
    public void testingActionTest() throws InterruptedException {
        loginStep();
        newActionStep();
        assertEquals(3,5); //Это  сделал специально, чтобы тест всегда падал и можно было получить скрин
    }


    @Step("First Step")
    private void loginStep(){
        LoginPageTest2 logpage = new LoginPageTest2();

        driver = logpage.login("GORLOV", "GORLOV");


        // getBytes("screen.png");
        // putScreen();
        saveAllureScreenshot();


    }

    @Step("Second Step")
    private void newActionStep() throws InterruptedException {
        HomePageTest homePage = new HomePageTest(driver);
        Thread.sleep(7000);
        homePage.newAct();
    }


    @Attachment(value = "Page screenshot")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }




    @AfterClass
    public void CloseDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Attachment
    public static byte[] getBytes(String resourceName) {
        try {
            return Files.readAllBytes(Paths.get("src/main/Pages", resourceName));
        }catch (IOException e){
            System.out.println("Не получилось прикрепить скрин" + e);
            return null;
        }
    }
}

