package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NavigationPage extends BasePage {

    public static String PROJECTS_BUTTON = "Projects";

    @Override
    public NavigationPage isPageOpened() {
        log.info("Waiting for Navigation page to be opened");
        $(byText(PROJECTS_BUTTON)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click on the button 'Projects'")
    public ProjectsList clickButtonProjects() {
        log.info("Click on the button 'Projects'");
        $(byText(PROJECTS_BUTTON)).click();
        return new ProjectsList();
    }

}
