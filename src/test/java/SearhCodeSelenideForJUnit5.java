import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearhCodeSelenideForJUnit5 {

    @BeforeAll
    static void beforeAll(){

        Configuration.holdBrowserOpen = true;
    }

    @Test
    void SelenideForJUnit5() {

        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
        $(".markdown-body").$$(".internal.present").findBy(text("Soft assertions")).click();
        $(".markdown-body").$$("ol li").findBy(text("JUnit5")).shouldBe(visible);
    }
}
