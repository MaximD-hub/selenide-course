import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
// чтобы можо было писать open(); без Selenide.open();

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        // открыть главную страницу
        open("https://github.com/");

        // ввести в поле поиска selenide и нажать enter
        $("[aria-label='Search or jump to…']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();

        // кликнуть на первый репозиторий из списка найденных
        $$("[data-testid='results-list'] a").first().click();

        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        sleep(5000);
    }
}