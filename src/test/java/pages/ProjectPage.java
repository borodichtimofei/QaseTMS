package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectPage extends BasePage {

    public static final By REPOSITORY = By.xpath("//p[contains(@class, 'header')]");
    public static final By CREATE_SUITE = By.id("create-suite-button");
    public static final By CREATE_CASE = By.id("create-case-button");

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

    @Step("Click on button 'Suite'")
    public SuiteModal clickSuite() {
        log.info("Click on button 'Suite'");
        $(CREATE_SUITE).click();
        return new SuiteModal();
    }

    @Step("Click on button 'Case'")
    public CaseModal clickCase() {
        log.info("Click on button 'Case'");
        $(CREATE_CASE).click();
        return new CaseModal();
    }

}

//label[text()='Description']