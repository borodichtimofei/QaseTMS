package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectPage extends BasePage {

    public static final By REPOSITORY = By.xpath("//p[contains(@class, 'header')]");

    @Override
    public ProjectPage isPageOpened() {
        log.info("Waiting for Project page to be opened");
        $(REPOSITORY).shouldBe(Condition.visible);
        return this;
    }

    @Step("Get project name")
    public String name() {
        log.info("Get project name");
        return $(REPOSITORY).getText();
    }
}
