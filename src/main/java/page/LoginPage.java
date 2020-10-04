package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement passwordInput;

    private final String email = "mazgajmaciek@gmail.com";
    private final String password = "polska0";

}
