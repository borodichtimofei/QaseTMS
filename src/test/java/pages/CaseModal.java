package pages;

import com.codeborne.selenide.Condition;
import dto.Case;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import wrappers.DropDown;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CaseModal extends BasePage {

    public static final By CASE_TITLE = By.id("title");
    public static final String SAVE = "Save";

    @Override
    public CaseModal isPageOpened() {
        log.info("Waiting for Login page to be opened");
        $(CASE_TITLE).shouldBe(Condition.visible);
        return this;
    }

    public CaseModal create(Case aCase) {
        $(CASE_TITLE).sendKeys("Test");
        new DropDown("Status").select(aCase.getStatus());
        new DropDown("Suite").select(aCase.getSuite());
        new DropDown("Severity").select(aCase.getSeverity());
        new DropDown("Priority").select(aCase.getPriority());
        new DropDown("Type").select(aCase.getType());
        new DropDown("Layer").select(aCase.getLayer());
        new DropDown("Milestone").select(aCase.getMilestone());
        return this;
    }

    public ProjectPage save() {
        $(byText(SAVE)).click();
        return new ProjectPage();
    }


}
