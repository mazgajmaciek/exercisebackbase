package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ArticlePage extends Page {

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[@class='article-page']//h1")
    WebElement articleTitle;

    @FindBy(xpath = ".//div[@class='row article-content']//p")
    WebElement articleText;

    @FindBy(xpath = ".//a[contains(text(), 'Edit Article')]")
    List<WebElement> editArticleBtn;

    public WebElement getArticleTitle() {
        return articleTitle;
    }

    public String getArticleText() {
        return articleText.getText();
    }

    public ArticleEditorPage clickEditArticleButton() {
        editArticleBtn.get(0).click();
        return new ArticleEditorPage(driver);
    }
}
