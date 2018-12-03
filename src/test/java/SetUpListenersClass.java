import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class SetUpListenersClass extends BasicPage implements ITestListener {

    /*В этом классе описаны методы, которые срабатывают в момент работы теста.
    Можно погуглить что-то в таком ключе "Слушатели TestNG, TestNG Listeners.
    По названию метода можно понять в какой момент теста он срабатывает
     */

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //putScreen();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("ТЕСТ УПАЛ");

        putScreen(); //Когда тест падает, то вызываем метод из родительского класса (базовой страницы)


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}
