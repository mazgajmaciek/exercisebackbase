package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor jsExec;

    public Page(WebDriver driver) {
        setWebDriver(driver);
    }

    public void setWebDriver(WebDriver driver) {
        Page.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        waitForJSandJQueryToLoad();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        jsExec = (JavascriptExecutor) driver;
    }
}
