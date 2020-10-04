package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//a[@routerlink='/editor']")
    private WebElement newPostBtn;

    @FindBy(xpath = ".//a[contains(text(), 'Sign in')]")
    private WebElement signBtn;

    public LoginPage getLoginPage() {
        click(signBtn);
        return new LoginPage(driver);
    }
}
