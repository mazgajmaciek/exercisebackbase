package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public void click(WebElement webElement) {
        try {
            if (webElement.isDisplayed()) {
                webElement.click();
            }
        } catch (StaleElementReferenceException var1) {
            throw new Error("Element " + webElement.getText() + " not visible");
        }
    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
