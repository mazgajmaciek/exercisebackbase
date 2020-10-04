package backbase;

import org.testng.annotations.Test;
import page.ArticlePage;
import page.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class EditArticleTest extends BaseTest {

    @Test(groups = {"updateArticle"})
    public void tc0103_updateArticle() {
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");

        String newArticleText = faker.commerce().productName();

        new HomePage(driver)
                .getLoginPage()
                .login()
                .getUserPage()
                .clickAvailableArticle()
                .clickEditArticleButton()
                .editArticleText(newArticleText);

        assertThat(new ArticlePage(driver).getArticleText()).isEqualTo(newArticleText);
    }
}

