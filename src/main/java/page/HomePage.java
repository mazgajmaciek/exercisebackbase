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

    @FindBy(xpath = ".//ul[@class='nav navbar-nav pull-xs-right']//a[contains(@href,'#/profile/')]")
    private WebElement userPageBtn;

    public LoginPage getLoginPage() {
        click(signBtn);
        return new LoginPage(driver);
    }

    public ArticleEditorPage getArticleEditorPage() {
        click(newPostBtn);
        return new ArticleEditorPage(driver);
    }

    public UserPage getUserPage() {
        click(userPageBtn);
        return new UserPage(driver);
    }

    public String getCurrentUsername() {
        return userPageBtn.getText();
    }
}
