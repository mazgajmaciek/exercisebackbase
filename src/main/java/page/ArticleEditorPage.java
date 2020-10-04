package page;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticleEditorPage extends Page{

    public ArticleEditorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@placeholder='Article Title']")
    private WebElement articleTitleInput;

    @FindBy(xpath = ".//input[contains(@placeholder, 'this article about')]")
    private WebElement articleAboutInput;

    @FindBy(xpath = ".//textarea[@placeholder='Write your article (in markdown)']")
    private WebElement articleTextInput;

    @FindBy(xpath = ".//button[contains(text(),'Publish Article')]")
    private WebElement publishArticleButton;

    public ArticlePage createNewArticle(String title, String about, String text) {
        articleTitleInput.sendKeys(title);
        articleAboutInput.sendKeys(about);
        articleTextInput.sendKeys(text);
        click(publishArticleButton);
        waitForJSandJQueryToLoad();
        return new ArticlePage(driver);
    }

    public ArticlePage editArticleText(String newArticleText) {
        articleTextInput.sendKeys(newArticleText);
        click(publishArticleButton);
        waitForJSandJQueryToLoad();
        return new ArticlePage(driver);
    }


}
