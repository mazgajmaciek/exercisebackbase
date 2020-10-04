package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage extends Page {

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[@class='article-preview']")
    List<WebElement> articlesList;

    public void clickAvailableArticle() {
        if (!articlesList.isEmpty()) {
            articlesList.get(0).click();
        }
    }

}
