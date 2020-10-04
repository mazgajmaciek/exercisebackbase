package backbase;

import org.testng.annotations.BeforeGroups;

public class NewArticleTest extends BaseTest {
    @BeforeGroups(groups = {"loginScenario"})
    public static void localSetUp() {
        driver.get("https://qa-task.backbasecloud.com/#/login");
    }


}
