package backbase;

import api.RestAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import page.HomePage;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteArticleTest extends BaseTest {


    @Test(groups = {"removeArticle"})
    public void tc0102_removeArticle() {
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
        String username = new HomePage(driver)
                .getLoginPage()
                .login()
                .getCurrentUsername();

        Response response = RestAPI.getUserArticles(username);

        List<String> articleSlugs = response.getBody().jsonPath().getList("articles.slug");
        assertThat(articleSlugs).isNotEmpty();

        Response articleRemovalResponse = RestAPI.deleteArticle(articleSlugs.get(0));
        System.out.println(articleRemovalResponse.prettyPrint());
        assertThat(articleRemovalResponse.getStatusCode()).isEqualTo(204);

    }

}
