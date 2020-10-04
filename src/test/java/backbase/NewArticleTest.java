package backbase;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class NewArticleTest extends BaseTest {

    @BeforeGroups(groups = {"addNewArticle"})
    public static void localSetUp() {

    }

    @Test(groups = {"addNewArticle"})
    public void tc0101_addNewArticle() {
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
        new HomePage(driver)
                .getLoginPage()
                .login();
    }
}
