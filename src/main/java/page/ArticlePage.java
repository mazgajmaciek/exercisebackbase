package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends Page {

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[@class='article-page']//h1")
    WebElement articleTitle;

    @FindBy(xpath = ".//div[@class='row article-content']//p")
    WebElement articleText;

    public WebElement getArticleTitle() {
        return articleTitle;
    }

    public WebElement getArticleText() {
        return articleText;
    }
}
