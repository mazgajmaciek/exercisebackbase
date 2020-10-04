package backbase;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import page.ArticlePage;
import page.HomePage;
import page.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NewArticleTest extends BaseTest {

    String articleTitle = faker.name().title();
    String articleAbout = faker.ancient().hero();
    String articleText = faker.funnyName().name();

    @Test(groups = {"addNewArticle"})
    public void tc0101_addNewArticle() {
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
        new HomePage(driver)
                .getLoginPage()
                .login()
                .getArticleEditorPage()
                .createNewArticle(articleTitle, articleAbout, articleText);

        ArticlePage articlePage = new ArticlePage(driver);

        assertThat(articlePage.getArticleText()).isEqualTo(articleText);
        assertThat(articlePage.getArticleTitle().getText()).isEqualTo(articleTitle);
    }
}
