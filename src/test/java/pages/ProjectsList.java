package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsList extends BasePage {

    public static final By CREATE_BUTTON = By.id("createButton");

    public ProjectsList openPage() {
        open("projects");
        return this;
    }

    @Override
    public ProjectsList isPageOpened() {
        log.info("Waiting for Project list to be opened");
        $(CREATE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click button 'Create new project'")
    public NewProjectPage clickButtonNewProject() {
        log.info("Click button 'Create new project'");
        $(CREATE_BUTTON).click();
        return new NewProjectPage();
    }

    @Step("Project creation check with name: {name}")
    public boolean validate(String name) {
        log.info("Project creation check with name: {}", name);
        $$("[class=defect-title]").findBy(Condition.text(name)).shouldBe(Condition.visible);
        return $$("[class=defect-title]").findBy(Condition.text(name)).isDisplayed();
    }

    @Step("Click project with name: {name}")
    public ProjectPage clickProject(String name) {
        log.info("Click project with name: {}", name);
        $$("[class=defect-title]").findBy(Condition.text(name)).click();
        return new ProjectPage();
    }
}
