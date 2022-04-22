package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewProjectPage extends BasePage {

    public static final By TITLE = By.xpath("//h1[contains(text(),'New Project')]");
    public static final By INPUT_PROJECT_NAME = By.id("inputTitle");
    public static final By INPUT_PROJECT_CODE = By.id("inputCode");
    public static final By INPUT_PROJECT_DESCRIPTION = By.id("inputDescription");

    public static final By CHECK_BOX_PUBLIC = By.id("public-access-type");


    @Override
    public NewProjectPage isPageOpened() {
        log.info("Waiting for New project page to be opened");
        $(TITLE).shouldBe(Condition.visible);
        return this;
    }

    @Step("Input project information: {project}")
    public NewProjectPage inputInfo(Project project) {
        log.info("Input project name: {}, code project: {}, description {}", project.getProjectName(),
                project.getProjectCode(), project.getProjectDescription());
        $(INPUT_PROJECT_NAME).sendKeys(project.getProjectName());
        $(INPUT_PROJECT_CODE).sendKeys(project.getProjectCode());
        $(INPUT_PROJECT_DESCRIPTION).sendKeys(project.getProjectDescription());
        return this;
    }

    @Step("Click check box 'Public'")
    public NewProjectPage checkBoxPublic() {
        log.info("Click check box 'Public'");
        $(CHECK_BOX_PUBLIC).click();
        return this;
    }

    @Step("Click button 'Create project'")
    public ProjectPage create() {
        log.info("Click button 'Create project'");
        $(byText("Create project")).click();
        return new ProjectPage();
    }
}
